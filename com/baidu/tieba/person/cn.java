package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class cn extends com.baidu.adp.base.e {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/listFriend";
    private static TbHttpMessageTask b = new TbHttpMessageTask(1002000, a);
    private com.baidu.tieba.data.am c = new com.baidu.tieba.data.am();
    private boolean d;
    private String e;
    private int f;

    static {
        b.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(b);
    }

    public cn(boolean z) {
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

    public void a(com.baidu.tieba.data.am amVar) {
        this.c = amVar;
    }

    public com.baidu.tieba.data.am b() {
        return this.c;
    }

    public void c() {
        super.sendMessage(new PersonFriendByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1002000);
        if (!z) {
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(i)).toString());
        httpMessage.addParam("res_num", new StringBuilder(String.valueOf(i2)).toString());
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
