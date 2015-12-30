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
    public static final BdUniqueId cQb = BdUniqueId.gen();
    public static final BdUniqueId cQc = BdUniqueId.gen();
    private a cPS;
    private boolean cQd;
    private PersonListActivity cQe;
    public CustomMessageListener cQf;
    public HttpMessageListener chs;
    private String mId;
    private int mPage;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void F(String str, boolean z);

        com.baidu.tieba.person.data.p d(com.baidu.tieba.person.data.p pVar, boolean z);
    }

    public bu(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.mPage = 0;
        this.chs = new bv(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.cQf = new bw(this, CmdConfigCustom.CMD_READ_PERSON_LIST);
        this.cQe = personListActivity;
        this.cQd = true;
        this.mId = null;
        this.cPS = aVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void kN(int i) {
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

    public void cB(boolean z) {
        this.cQd = z;
    }

    public boolean apd() {
        return this.cQd;
    }

    public void Kf() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.cQd) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.chs);
    }

    public void ape() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.cQd) {
            httpMessage.setTag(cQc);
        } else {
            httpMessage.setTag(cQb);
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

    public void apf() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_READ_PERSON_LIST, new bx());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.cQf);
    }

    public void apg() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.cQd);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aph() {
        MessageManager.getInstance().unRegisterListener(this.cQf);
        MessageManager.getInstance().unRegisterListener(this.chs);
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
