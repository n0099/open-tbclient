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
public class bu extends com.baidu.adp.base.e<PersonListActivity> {
    public static final BdUniqueId cLL = BdUniqueId.gen();
    public static final BdUniqueId cLM = BdUniqueId.gen();
    private a cLC;
    private boolean cLN;
    private PersonListActivity cLO;
    public CustomMessageListener cLP;
    public HttpMessageListener cds;
    private String mId;
    private int mPage;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void G(String str, boolean z);

        com.baidu.tieba.person.data.n d(com.baidu.tieba.person.data.n nVar, boolean z);
    }

    public bu(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.cds = new bv(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.cLP = new bw(this, CmdConfigCustom.CMD_READ_PERSON_LIST);
        this.cLO = personListActivity;
        this.cLN = true;
        this.mId = null;
        this.cLC = aVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void kq(int i) {
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

    public void cA(boolean z) {
        this.cLN = z;
    }

    public boolean anS() {
        return this.cLN;
    }

    public void JM() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.cLN) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cds);
    }

    public void anT() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.cLN) {
            httpMessage.setTag(cLM);
        } else {
            httpMessage.setTag(cLL);
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

    public void anU() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_READ_PERSON_LIST, new bx());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.cLP);
    }

    public void anV() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.cLN);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void anW() {
        MessageManager.getInstance().unRegisterListener(this.cLP);
        MessageManager.getInstance().unRegisterListener(this.cds);
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
