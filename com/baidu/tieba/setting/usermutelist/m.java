package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.e {
    public static int dpf = 0;
    private a doT;
    private com.baidu.adp.framework.listener.a dpg = new n(this, CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);

    /* loaded from: classes.dex */
    public interface a {
        void a(ArrayList<MuteUser> arrayList, int i, String str);
    }

    public m(a aVar) {
        this.doT = aVar;
        registerListener(this.dpg);
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

    public void bC(long j) {
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
        MessageManager.getInstance().unRegisterListener(this.dpg);
    }
}
