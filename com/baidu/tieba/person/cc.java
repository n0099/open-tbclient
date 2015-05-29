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
    public static final BdUniqueId bTC = BdUniqueId.gen();
    public static final BdUniqueId bTD = BdUniqueId.gen();
    private boolean bTE;
    private PersonListActivity bTF;
    public CustomMessageListener bTG;
    private cf bTt;
    public HttpMessageListener bvZ;
    private String mId;
    private int mPage;
    private int mSex;

    public cc(PersonListActivity personListActivity, cf cfVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bvZ = new cd(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bTG = new ce(this, 2001192);
        this.bTF = personListActivity;
        this.bTE = true;
        this.mId = null;
        this.bTt = cfVar;
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
        this.bTE = z;
    }

    public boolean aeE() {
        return this.bTE;
    }

    public void HL() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bTE) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bvZ);
    }

    public void aeF() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bTE) {
            httpMessage.setTag(bTD);
        } else {
            httpMessage.setTag(bTC);
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

    public void aeG() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new cg());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bTG);
    }

    public void aeH() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bTE);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aeI() {
        MessageManager.getInstance().unRegisterListener(this.bTG);
        MessageManager.getInstance().unRegisterListener(this.bvZ);
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
