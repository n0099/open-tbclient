package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.usermute.request.UserMuteCheckRequestMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e {
    private a dQv;
    private com.baidu.adp.framework.listener.a doS;
    private Object mExtra;

    /* loaded from: classes.dex */
    public interface a {
        void a(DataRes dataRes, int i, String str, Object obj);
    }

    public i(com.baidu.adp.base.h<?> hVar, a aVar) {
        super(hVar);
        this.doS = new j(this, CmdConfigHttp.CMD_USER_MUTE_CHECK, 303040);
        this.dQv = aVar;
        this.doS.getHttpMessageListener().setSelfListener(true);
        this.doS.getSocketMessageListener().setSelfListener(true);
        registerListener(this.doS);
        com.baidu.tieba.tbadkCore.a.a.c(303040, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    public void d(long j, long j2) {
        a(j, j2, null);
    }

    public void a(long j, long j2, Object obj) {
        UserMuteCheckRequestMessage userMuteCheckRequestMessage = new UserMuteCheckRequestMessage();
        userMuteCheckRequestMessage.setUserIdF(j);
        userMuteCheckRequestMessage.setUserIdT(j2);
        if (obj != null) {
            this.mExtra = obj;
        }
        sendMessage(userMuteCheckRequestMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.doS);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
