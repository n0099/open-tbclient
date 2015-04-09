package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.base.f<PersonListActivity> {
    public static final BdUniqueId bQX = BdUniqueId.gen();
    public static final BdUniqueId bQY = BdUniqueId.gen();
    private bm bQO;
    private boolean bQZ;
    private PersonListActivity bRa;
    public CustomMessageListener bRb;
    public HttpMessageListener btq;
    private String mId;
    private int mPage;
    private int mSex;

    public bj(PersonListActivity personListActivity, bm bmVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.btq = new bk(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bRb = new bl(this, 2001192);
        this.bRa = personListActivity;
        this.bQZ = true;
        this.mId = null;
        this.bQO = bmVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void hD(int i) {
        this.mPage = i;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public int getSex() {
        return this.mSex;
    }

    public void bX(boolean z) {
        this.bQZ = z;
    }

    public boolean adw() {
        return this.bQZ;
    }

    public void GH() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bQZ) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.btq);
    }

    public void adx() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bQZ) {
            httpMessage.setTag(bQY);
        } else {
            httpMessage.setTag(bQX);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam(SapiAccountManager.SESSION_UID, this.mId);
        }
        if (this.mPage != 0) {
            this.mPage++;
            httpMessage.addParam("pn", String.valueOf(this.mPage));
        }
        sendMessage(httpMessage);
    }

    public void ady() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new bn());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bRb);
    }

    public void adz() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bQZ);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void adA() {
        MessageManager.getInstance().unRegisterListener(this.bRb);
        MessageManager.getInstance().unRegisterListener(this.btq);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
