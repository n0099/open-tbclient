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
import d.b.b.a.f;
/* loaded from: classes5.dex */
public class UserBlockSetModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public long f21686e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.m.a f21687f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f21688g;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockSetRequestMessage userBlockSetRequestMessage;
            if (UserBlockSetModel.this.f21687f == null || responsedMessage == null || (userBlockSetRequestMessage = (UserBlockSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || userBlockSetRequestMessage.getBlockUserId() != UserBlockSetModel.this.f21686e) {
                return;
            }
            if (!(responsedMessage instanceof UserBlockSetSocketResponseMessage) && !(responsedMessage instanceof UserBlockSetHttpResponseMessage)) {
                UserBlockSetModel.this.f21687f.onError(-1, UserBlockSetModel.this.w(R.string.block_user_fail));
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (error == 0 && !responsedMessage.hasError()) {
                if (StringUtils.isNull(errorString)) {
                    errorString = UserBlockSetModel.this.w(R.string.block_user_success);
                }
                UserBlockSetModel.this.f21687f.onSuccess(errorString);
            } else {
                if (StringUtils.isNull(errorString)) {
                    errorString = UserBlockSetModel.this.w(R.string.block_user_fail);
                }
                UserBlockSetModel.this.f21687f.onError(error, errorString);
            }
            UserBlockSetModel.this.f21686e = -1L;
        }
    }

    public UserBlockSetModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f21688g = new a(CmdConfigHttp.CMD_USER_BLOCK_SET, 309697);
        setUniqueId(bdUniqueId);
        x();
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
        this.f21686e = -1L;
        MessageManager.getInstance().unRegisterListener(this.f21688g);
    }

    public final String w(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void x() {
        d.b.i0.c3.d0.a.h(309697, UserBlockSetSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309697, CmdConfigHttp.CMD_USER_BLOCK_SET, TbConfig.URL_USER_BLOCK_SET, UserBlockSetHttpResponseMessage.class, true, false, true, false);
        this.f21688g.getHttpMessageListener().setSelfListener(true);
        this.f21688g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f21688g);
    }

    public void y(long j, int i, int i2, int i3) {
        this.f21686e = j;
        UserBlockSetRequestMessage userBlockSetRequestMessage = new UserBlockSetRequestMessage();
        userBlockSetRequestMessage.setFollow(i);
        userBlockSetRequestMessage.setInteract(i2);
        userBlockSetRequestMessage.setChat(i3);
        userBlockSetRequestMessage.setBlockUserId(this.f21686e);
        sendMessage(userBlockSetRequestMessage);
    }

    public void z(d.b.h0.m.a aVar) {
        this.f21687f = aVar;
    }
}
