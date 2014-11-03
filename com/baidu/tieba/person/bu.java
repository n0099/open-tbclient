package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.base.e {
    public static final BdUniqueId bDp = BdUniqueId.gen();
    public static final BdUniqueId bDq = BdUniqueId.gen();
    private bx bDg;
    private boolean bDr;
    public HttpMessageListener bDs;
    public CustomMessageListener bDt;
    private String mId;
    private int mPage;
    private int mSex;

    public bu(BaseActivity baseActivity, bx bxVar) {
        super(baseActivity);
        this.mPage = 0;
        this.bDs = new bv(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bDt = new bw(this, 2001192);
        this.bDr = true;
        this.mId = null;
        this.bDg = bxVar;
    }

    public int getPage() {
        return this.mPage;
    }

    public void gZ(int i) {
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

    public void ev(boolean z) {
        this.bDr = z;
    }

    public boolean aag() {
        return this.bDr;
    }

    public void HQ() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bDr) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bDs);
    }

    public void aah() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bDr) {
            httpMessage.setTag(bDq);
        } else {
            httpMessage.setTag(bDp);
        }
        if (this.mId != null && !this.mId.equals(TbadkApplication.getCurrentAccount())) {
            httpMessage.addParam(SapiAccountManager.SESSION_UID, this.mId);
        }
        if (this.mPage != 0) {
            this.mPage++;
            httpMessage.addParam("pn", String.valueOf(this.mPage));
        }
        sendMessage(httpMessage);
    }

    public void aai() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new by());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bDt);
    }

    public void aaj() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bDr);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aak() {
        MessageManager.getInstance().unRegisterListener(this.bDt);
        MessageManager.getInstance().unRegisterListener(this.bDs);
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
