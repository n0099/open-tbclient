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
public class bl extends com.baidu.adp.base.f<PersonListActivity> {
    public static final BdUniqueId bIA = BdUniqueId.gen();
    public static final BdUniqueId bIB = BdUniqueId.gen();
    private boolean bIC;
    public HttpMessageListener bID;
    public CustomMessageListener bIE;
    private bo bIr;
    private String mId;
    private int mPage;
    private int mSex;

    public bl(PersonListActivity personListActivity, bo boVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bID = new bm(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bIE = new bn(this, 2001192);
        this.bIC = true;
        this.mId = null;
        this.bIr = boVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void hr(int i) {
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

    public void bU(boolean z) {
        this.bIC = z;
    }

    public boolean abc() {
        return this.bIC;
    }

    public void JC() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bIC) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bID);
    }

    public void abd() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bIC) {
            httpMessage.setTag(bIB);
        } else {
            httpMessage.setTag(bIA);
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

    public void abe() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new bp());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bIE);
    }

    public void abf() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bIC);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void abg() {
        MessageManager.getInstance().unRegisterListener(this.bIE);
        MessageManager.getInstance().unRegisterListener(this.bID);
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
