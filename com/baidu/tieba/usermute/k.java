package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.usermute.request.UserMuteQueryRequestMessage;
import com.baidu.tieba.usermute.response.UserMuteQueryHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteQuerySocketResponsedMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    public static int cOY = 0;
    private com.baidu.adp.framework.listener.a cOZ = new l(this, CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
    private a czd;

    /* loaded from: classes.dex */
    public interface a {
        void a(ArrayList<MuteUser> arrayList, int i, String str);
    }

    public k(a aVar) {
        this.czd = aVar;
        registerListener(this.cOZ);
        com.baidu.tieba.tbadkCore.a.a.c(303028, UserMuteQuerySocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(303028, CmdConfigHttp.CMD_USER_MUTE_QUERY, TbConfig.USER_MUTE_QUERY, UserMuteQueryHttpResponsedMessage.class, false, false, true, false);
    }

    public void a(long j, int i, int i2) {
        UserMuteQueryRequestMessage userMuteQueryRequestMessage = new UserMuteQueryRequestMessage();
        userMuteQueryRequestMessage.setUserId(j);
        userMuteQueryRequestMessage.setPn(i);
        userMuteQueryRequestMessage.setRn(i2);
        sendMessage(userMuteQueryRequestMessage);
    }

    public void aB(long j) {
        a(j, 1, 10);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cOZ);
    }
}
