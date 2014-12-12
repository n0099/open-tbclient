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
public class bm extends com.baidu.adp.base.f<PersonListActivity> {
    public static final BdUniqueId bGO = BdUniqueId.gen();
    public static final BdUniqueId bGP = BdUniqueId.gen();
    private bp bGF;
    private boolean bGQ;
    public HttpMessageListener bGR;
    public CustomMessageListener bGS;
    private String mId;
    private int mPage;
    private int mSex;

    public bm(PersonListActivity personListActivity, bp bpVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bGR = new bn(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bGS = new bo(this, 2001192);
        this.bGQ = true;
        this.mId = null;
        this.bGF = bpVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void hi(int i) {
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

    public void bR(boolean z) {
        this.bGQ = z;
    }

    public boolean aax() {
        return this.bGQ;
    }

    public void Je() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bGQ) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bGR);
    }

    public void aay() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bGQ) {
            httpMessage.setTag(bGP);
        } else {
            httpMessage.setTag(bGO);
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

    public void aaz() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new bq());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bGS);
    }

    public void aaA() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bGQ);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aaB() {
        MessageManager.getInstance().unRegisterListener(this.bGS);
        MessageManager.getInstance().unRegisterListener(this.bGR);
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
