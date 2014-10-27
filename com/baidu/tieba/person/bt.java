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
public class bt extends com.baidu.adp.base.e {
    public static final BdUniqueId bDb = BdUniqueId.gen();
    public static final BdUniqueId bDc = BdUniqueId.gen();
    private bw bCS;
    private boolean bDd;
    public HttpMessageListener bDe;
    public CustomMessageListener bDf;
    private String mId;
    private int mPage;
    private int mSex;

    public bt(BaseActivity baseActivity, bw bwVar) {
        super(baseActivity);
        this.mPage = 0;
        this.bDe = new bu(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.bDf = new bv(this, 2001192);
        this.bDd = true;
        this.mId = null;
        this.bCS = bwVar;
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
        this.bDd = z;
    }

    public boolean aae() {
        return this.bDd;
    }

    public void HM() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bDd) {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/page";
        } else {
            str = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bDe);
    }

    public void aaf() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        if (this.bDd) {
            httpMessage.setTag(bDc);
        } else {
            httpMessage.setTag(bDb);
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

    public void aag() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001192, new bx());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bDf);
    }

    public void aah() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.bDd);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
    }

    public void aai() {
        MessageManager.getInstance().unRegisterListener(this.bDf);
        MessageManager.getInstance().unRegisterListener(this.bDe);
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
