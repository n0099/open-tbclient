package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class cc extends com.baidu.adp.base.f<PersonListActivity> {
    public static final BdUniqueId bTD = BdUniqueId.gen();
    public static final BdUniqueId bTE = BdUniqueId.gen();
    private boolean bTF;
    private PersonListActivity bTG;
    public CustomMessageListener bTH;
    private cf bTu;
    public HttpMessageListener bwa;
    private String mId;
    private int mPage;
    private int mSex;

    public cc(PersonListActivity personListActivity, cf cfVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bwa = new cd(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bTH = new ce(this, 2001192);
        this.bTG = personListActivity;
        this.bTF = true;
        this.mId = null;
        this.bTu = cfVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void hS(int i) {
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

    public void cg(boolean z) {
        this.bTF = z;
    }

    public boolean aeF() {
        return this.bTF;
    }

    public void HM() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bTF) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bwa);
    }

    public void aeG() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bTF) {
            httpMessage.setTag(bTE);
        } else {
            httpMessage.setTag(bTD);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.mId);
        }
        if (this.mPage != 0) {
            this.mPage++;
            httpMessage.addParam("pn", String.valueOf(this.mPage));
        }
        sendMessage(httpMessage);
    }

    public void aeH() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new cg());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bTH);
    }

    public void aeI() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bTF);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aeJ() {
        MessageManager.getInstance().unRegisterListener(this.bTH);
        MessageManager.getInstance().unRegisterListener(this.bwa);
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
