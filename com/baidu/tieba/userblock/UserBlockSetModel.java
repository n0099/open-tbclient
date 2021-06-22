package com.baidu.tieba.userblock;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.userblock.message.UserBlockSetHttpResponseMessage;
import com.baidu.tieba.userblock.message.UserBlockSetRequestMessage;
import com.baidu.tieba.userblock.message.UserBlockSetSocketResponseMessage;
import d.a.c.a.f;
/* loaded from: classes5.dex */
public class UserBlockSetModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public long f21330e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.m.a f21331f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f21332g;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockSetRequestMessage userBlockSetRequestMessage;
            if (UserBlockSetModel.this.f21331f == null || responsedMessage == null || (userBlockSetRequestMessage = (UserBlockSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || userBlockSetRequestMessage.getBlockUserId() != UserBlockSetModel.this.f21330e) {
                return;
            }
            if (!(responsedMessage instanceof UserBlockSetSocketResponseMessage) && !(responsedMessage instanceof UserBlockSetHttpResponseMessage)) {
                UserBlockSetModel.this.f21331f.onError(-1, UserBlockSetModel.this.A(R.string.block_user_fail));
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (error == 0 && !responsedMessage.hasError()) {
                if (StringUtils.isNull(errorString)) {
                    errorString = UserBlockSetModel.this.A(R.string.block_user_success);
                }
                UserBlockSetModel.this.f21331f.onSuccess(errorString);
            } else {
                if (StringUtils.isNull(errorString)) {
                    errorString = UserBlockSetModel.this.A(R.string.block_user_fail);
                }
                UserBlockSetModel.this.f21331f.onError(error, errorString);
            }
            UserBlockSetModel.this.f21330e = -1L;
        }
    }

    public UserBlockSetModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f21332g = new a(CmdConfigHttp.CMD_USER_BLOCK_SET, 309697);
        setUniqueId(bdUniqueId);
        B();
    }

    public final String A(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public void B() {
        d.a.o0.e3.d0.a.h(309697, UserBlockSetSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309697, CmdConfigHttp.CMD_USER_BLOCK_SET, TbConfig.URL_USER_BLOCK_SET, UserBlockSetHttpResponseMessage.class, true, false, true, false);
        this.f21332g.getHttpMessageListener().setSelfListener(true);
        this.f21332g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f21332g);
    }

    public void C(long j, int i2, int i3, int i4) {
        this.f21330e = j;
        UserBlockSetRequestMessage userBlockSetRequestMessage = new UserBlockSetRequestMessage();
        userBlockSetRequestMessage.setFollow(i2);
        userBlockSetRequestMessage.setInteract(i3);
        userBlockSetRequestMessage.setChat(i4);
        userBlockSetRequestMessage.setBlockUserId(this.f21330e);
        sendMessage(userBlockSetRequestMessage);
    }

    public void D(d.a.n0.m.a aVar) {
        this.f21331f = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        this.f21330e = -1L;
        MessageManager.getInstance().unRegisterListener(this.f21332g);
    }
}
