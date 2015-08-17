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
public class bs extends com.baidu.adp.base.e<PersonListActivity> {
    public static final BdUniqueId ckl = BdUniqueId.gen();
    public static final BdUniqueId ckm = BdUniqueId.gen();
    public HttpMessageListener bJQ;
    private a ckc;
    private boolean ckn;
    private PersonListActivity cko;
    public CustomMessageListener ckp;
    private String mId;
    private int mPage;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void B(String str, boolean z);

        com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z);
    }

    public bs(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.bJQ = new bt(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.ckp = new bu(this, CmdConfigCustom.CMD_READ_PERSON_LIST);
        this.cko = personListActivity;
        this.ckn = true;
        this.mId = null;
        this.ckc = aVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void iM(int i) {
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

    public void cj(boolean z) {
        this.ckn = z;
    }

    public boolean agx() {
        return this.ckn;
    }

    public void Iz() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.ckn) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bJQ);
    }

    public void agy() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.ckn) {
            httpMessage.setTag(ckm);
        } else {
            httpMessage.setTag(ckl);
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

    public void agz() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_READ_PERSON_LIST, new bv());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.ckp);
    }

    public void agA() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.ckn);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void agB() {
        MessageManager.getInstance().unRegisterListener(this.ckp);
        MessageManager.getInstance().unRegisterListener(this.bJQ);
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
