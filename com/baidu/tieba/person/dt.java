package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dt extends com.baidu.adp.base.e {
    public static final BdUniqueId a = BdUniqueId.gen();
    public static final BdUniqueId b = BdUniqueId.gen();
    private int g;
    private dw h;
    private int i = 0;
    public HttpMessageListener c = new du(this, CmdConfigHttp.PIC_PERSONAL_LIST);
    public CustomMessageListener d = new dv(this, 2001192);
    private boolean e = true;
    private String f = null;

    public dt(BaseActivity baseActivity, dw dwVar) {
        this.h = dwVar;
    }

    public int a() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.f = str;
    }

    public String b() {
        return this.f;
    }

    public void b(int i) {
        this.g = i;
    }

    public int c() {
        return this.g;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean d() {
        return this.e;
    }

    public void e() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.e) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.c);
    }

    public void f() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.e) {
            httpMessage.setTag(b);
        } else {
            httpMessage.setTag(a);
        }
        if (this.f != null && !this.f.equals(TbadkApplication.getCurrentAccount())) {
            httpMessage.addParam(SapiAccountManager.SESSION_UID, this.f);
        }
        if (this.i != 0) {
            this.i++;
            httpMessage.addParam("pn", String.valueOf(this.i));
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void g() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new dx());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        MessageManager.getInstance().registerListener(this.d);
    }

    public void h() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.e);
        requestLocalPersonListMessage.setUid(this.f);
        MessageManager.getInstance().sendMessage(requestLocalPersonListMessage);
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.d);
        MessageManager.getInstance().unRegisterListener(this.c);
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
