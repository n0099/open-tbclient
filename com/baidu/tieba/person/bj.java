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
    public static final BdUniqueId bQH = BdUniqueId.gen();
    public static final BdUniqueId bQI = BdUniqueId.gen();
    private boolean bQJ;
    private PersonListActivity bQK;
    public CustomMessageListener bQL;
    private bm bQy;
    public HttpMessageListener bsZ;
    private String mId;
    private int mPage;
    private int mSex;

    public bj(PersonListActivity personListActivity, bm bmVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bsZ = new bk(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bQL = new bl(this, 2001192);
        this.bQK = personListActivity;
        this.bQJ = true;
        this.mId = null;
        this.bQy = bmVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void hA(int i) {
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

    public void bZ(boolean z) {
        this.bQJ = z;
    }

    public boolean adh() {
        return this.bQJ;
    }

    public void GB() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bQJ) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bsZ);
    }

    public void adi() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bQJ) {
            httpMessage.setTag(bQI);
        } else {
            httpMessage.setTag(bQH);
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

    public void adj() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new bn());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bQL);
    }

    public void adk() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bQJ);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void adl() {
        MessageManager.getInstance().unRegisterListener(this.bQL);
        MessageManager.getInstance().unRegisterListener(this.bsZ);
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
