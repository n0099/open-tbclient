package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.e<PersonListActivity> {
    public static final BdUniqueId cqV = BdUniqueId.gen();
    public static final BdUniqueId cqW = BdUniqueId.gen();
    public HttpMessageListener bNU;
    private a cqM;
    private boolean cqX;
    private PersonListActivity cqY;
    public CustomMessageListener cqZ;
    private String mId;
    private int mPage;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void E(String str, boolean z);

        com.baidu.tieba.person.data.a d(com.baidu.tieba.person.data.a aVar, boolean z);
    }

    public bt(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bNU = new bu(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.cqZ = new bv(this, CmdConfigCustom.CMD_READ_PERSON_LIST);
        this.cqY = personListActivity;
        this.cqX = true;
        this.mId = null;
        this.cqM = aVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void ji(int i) {
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

    public void cl(boolean z) {
        this.cqX = z;
    }

    public boolean aiN() {
        return this.cqX;
    }

    public void Ij() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.cqX) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bNU);
    }

    public void aiO() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.cqX) {
            httpMessage.setTag(cqW);
        } else {
            httpMessage.setTag(cqV);
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

    public void aiP() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_READ_PERSON_LIST, new bw());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.cqZ);
    }

    public void aiQ() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.cqX);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aiR() {
        MessageManager.getInstance().unRegisterListener(this.cqZ);
        MessageManager.getInstance().unRegisterListener(this.bNU);
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
