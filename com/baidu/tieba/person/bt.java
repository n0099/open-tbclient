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
    public static final BdUniqueId csr = BdUniqueId.gen();
    public static final BdUniqueId css = BdUniqueId.gen();
    public HttpMessageListener bOp;
    private a csi;
    private boolean cst;
    private PersonListActivity csu;
    public CustomMessageListener csv;
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
        this.bOp = new bu(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.csv = new bv(this, CmdConfigCustom.CMD_READ_PERSON_LIST);
        this.csu = personListActivity;
        this.cst = true;
        this.mId = null;
        this.csi = aVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void jw(int i) {
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

    public void cn(boolean z) {
        this.cst = z;
    }

    public boolean ajp() {
        return this.cst;
    }

    public void Iv() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.cst) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bOp);
    }

    public void ajq() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.cst) {
            httpMessage.setTag(css);
        } else {
            httpMessage.setTag(csr);
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

    public void ajr() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_READ_PERSON_LIST, new bw());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.csv);
    }

    public void ajs() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.cst);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void ajt() {
        MessageManager.getInstance().unRegisterListener(this.csv);
        MessageManager.getInstance().unRegisterListener(this.bOp);
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
