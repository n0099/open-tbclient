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
    private com.baidu.adp.framework.listener.a cLu;
    private a djd;
    private Object mExtra;

    /* loaded from: classes.dex */
    public interface a {
        void a(DataRes dataRes, int i, String str, Object obj);
    }

    public i(com.baidu.adp.base.h<?> hVar, a aVar) {
        super(hVar);
        this.cLu = new j(this, CmdConfigHttp.CMD_USER_MUTE_CHECK, 303040);
        this.djd = aVar;
        this.cLu.getHttpMessageListener().setSelfListener(true);
        this.cLu.getSocketMessageListener().setSelfListener(true);
        registerListener(this.cLu);
        com.baidu.tieba.tbadkCore.a.a.c(303040, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    public void e(long j, long j2) {
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
        MessageManager.getInstance().unRegisterListener(this.cLu);
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
