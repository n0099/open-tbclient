package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.e {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask b = new TbHttpMessageTask(1002001, a);
    private t c = new t();
    private boolean d;
    private String e;
    private int f;

    static {
        b.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(b);
    }

    public af(boolean z) {
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

    public t b() {
        return this.c;
    }

    public void c() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void a(boolean z, String str) {
        HttpMessage httpMessage = new HttpMessage(1002001);
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
