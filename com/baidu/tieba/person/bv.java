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
public class bv extends com.baidu.adp.base.e<PersonListActivity> {
    public static final BdUniqueId dub = BdUniqueId.gen();
    public static final BdUniqueId duc = BdUniqueId.gen();
    public HttpMessageListener cww;
    private a dtS;
    private boolean dud;
    private PersonListActivity due;
    public CustomMessageListener duf;
    private String mId;
    private int mPage;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void G(String str, boolean z);

        com.baidu.tieba.person.data.r d(com.baidu.tieba.person.data.r rVar, boolean z);
    }

    public bv(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.cww = new bw(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.duf = new bx(this, CmdConfigCustom.CMD_READ_PERSON_LIST);
        this.due = personListActivity;
        this.dud = true;
        this.mId = null;
        this.dtS = aVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void mC(int i) {
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

    public void cN(boolean z) {
        this.dud = z;
    }

    public boolean aqg() {
        return this.dud;
    }

    public void NL() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.dud) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cww);
    }

    public void aBC() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.dud) {
            httpMessage.setTag(duc);
        } else {
            httpMessage.setTag(dub);
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

    public void aBD() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_READ_PERSON_LIST, new by());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.duf);
    }

    public void aBE() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.dud);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void removeListener() {
        MessageManager.getInstance().unRegisterListener(this.duf);
        MessageManager.getInstance().unRegisterListener(this.cww);
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
