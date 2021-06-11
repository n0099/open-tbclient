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
import com.baidu.tieba.userblock.message.UserBlockInfoHttpResponseMessage;
import com.baidu.tieba.userblock.message.UserBlockInfoRequestMessage;
import com.baidu.tieba.userblock.message.UserBlockInfoSocketResponseMessage;
import d.a.c.a.f;
import tbclient.GetUserBlackInfo.DataRes;
/* loaded from: classes5.dex */
public class UserBlockInfoModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public long f21244e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.m.a f21245f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f21246g;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockInfoRequestMessage userBlockInfoRequestMessage;
            if (UserBlockInfoModel.this.f21245f == null || responsedMessage == null || (userBlockInfoRequestMessage = (UserBlockInfoRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || userBlockInfoRequestMessage.getBlockUserId() != UserBlockInfoModel.this.f21244e) {
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (error == 0 && !responsedMessage.hasError()) {
                DataRes data = responsedMessage instanceof UserBlockInfoSocketResponseMessage ? ((UserBlockInfoSocketResponseMessage) responsedMessage).getData() : null;
                if (responsedMessage instanceof UserBlockInfoHttpResponseMessage) {
                    data = ((UserBlockInfoHttpResponseMessage) responsedMessage).getData();
                }
                UserBlockInfoModel.this.f21245f.onSuccess(data);
                UserBlockInfoModel.this.f21244e = -1L;
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = UserBlockInfoModel.this.A(R.string.error_unkown_try_again);
            }
            UserBlockInfoModel.this.f21245f.onError(error, errorString);
        }
    }

    public UserBlockInfoModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f21246g = new a(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, 309698);
        setUniqueId(bdUniqueId);
        B();
    }

    public final String A(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public void B() {
        d.a.n0.e3.d0.a.h(309698, UserBlockInfoSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309698, CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, TbConfig.URL_GET_USER_BLOCK_INFO, UserBlockInfoHttpResponseMessage.class, true, false, true, false);
        this.f21246g.getHttpMessageListener().setSelfListener(true);
        this.f21246g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f21246g);
    }

    public void C(long j) {
        this.f21244e = j;
        UserBlockInfoRequestMessage userBlockInfoRequestMessage = new UserBlockInfoRequestMessage();
        userBlockInfoRequestMessage.setBlockUserId(j);
        sendMessage(userBlockInfoRequestMessage);
    }

    public void D(d.a.m0.m.a aVar) {
        this.f21245f = aVar;
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
        this.f21244e = -1L;
        MessageManager.getInstance().unRegisterListener(this.f21246g);
    }
}
