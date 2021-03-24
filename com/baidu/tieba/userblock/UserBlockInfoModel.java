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
import d.b.b.a.f;
import tbclient.GetUserBlackInfo.DataRes;
/* loaded from: classes5.dex */
public class UserBlockInfoModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public long f21682e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.m.a f21683f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f21684g;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockInfoRequestMessage userBlockInfoRequestMessage;
            if (UserBlockInfoModel.this.f21683f == null || responsedMessage == null || (userBlockInfoRequestMessage = (UserBlockInfoRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || userBlockInfoRequestMessage.getBlockUserId() != UserBlockInfoModel.this.f21682e) {
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (error == 0 && !responsedMessage.hasError()) {
                DataRes data = responsedMessage instanceof UserBlockInfoSocketResponseMessage ? ((UserBlockInfoSocketResponseMessage) responsedMessage).getData() : null;
                if (responsedMessage instanceof UserBlockInfoHttpResponseMessage) {
                    data = ((UserBlockInfoHttpResponseMessage) responsedMessage).getData();
                }
                UserBlockInfoModel.this.f21683f.onSuccess(data);
                UserBlockInfoModel.this.f21682e = -1L;
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = UserBlockInfoModel.this.w(R.string.error_unkown_try_again);
            }
            UserBlockInfoModel.this.f21683f.onError(error, errorString);
        }
    }

    public UserBlockInfoModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f21684g = new a(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, 309698);
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
        this.f21682e = -1L;
        MessageManager.getInstance().unRegisterListener(this.f21684g);
    }

    public final String w(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void x() {
        d.b.i0.c3.d0.a.h(309698, UserBlockInfoSocketResponseMessage.class, false, false);
        d.b.i0.c3.d0.a.c(309698, CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, TbConfig.URL_GET_USER_BLOCK_INFO, UserBlockInfoHttpResponseMessage.class, true, false, true, false);
        this.f21684g.getHttpMessageListener().setSelfListener(true);
        this.f21684g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f21684g);
    }

    public void y(long j) {
        this.f21682e = j;
        UserBlockInfoRequestMessage userBlockInfoRequestMessage = new UserBlockInfoRequestMessage();
        userBlockInfoRequestMessage.setBlockUserId(j);
        sendMessage(userBlockInfoRequestMessage);
    }

    public void z(d.b.h0.m.a aVar) {
        this.f21683f = aVar;
    }
}
