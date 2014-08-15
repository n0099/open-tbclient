package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask b = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, a);
    private s c = new s();
    private boolean d;
    private String e;
    private int f;

    static {
        b.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(b);
    }

    public ae(boolean z) {
        this.d = z;
    }

    public void a(String str) {
        this.e = str;
    }

    public String a() {
        return this.e;
    }

    public void a(int i) {
        this.f = i;
    }

    public s b() {
        return this.c;
    }

    public void c() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        if (!z) {
            httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        super.sendMessage(httpMessage);
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
