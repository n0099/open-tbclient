package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.personPolymeric.c.n;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericReqMsg;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e<BaseActivity> {
    private int ePL;
    private String ePM;
    private b eRk;
    private a eRl;
    private com.baidu.adp.framework.listener.a eRm;
    private CustomMessageListener evp;
    private CustomMessageListener evq;
    private CustomMessageListener evr;
    private n mPersonPolymericData;
    private int pageIndex;

    public c(BaseActivity baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.ePL = -1;
        this.ePM = "";
        this.pageIndex = 1;
        this.eRm = new d(this, CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        this.evr = new e(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.evp = new f(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.evq = new g(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        if (!z) {
            registerListener(this.evr);
            registerListener(this.evp);
            registerListener(this.evq);
        }
        registerListener(this.eRm);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eRk = bVar;
    }

    public void a(a aVar) {
        this.eRl = aVar;
    }

    public boolean hasData() {
        return !x.t(this.mPersonPolymericData.ard());
    }

    public void cJ(long j) {
        if (i.fZ() && this.mPersonPolymericData.hasMore()) {
            PersonPolymericReqMsg personPolymericReqMsg = new PersonPolymericReqMsg();
            personPolymericReqMsg.setUid(j);
            personPolymericReqMsg.setPn(this.pageIndex);
            personPolymericReqMsg.setPersonPolymericData(this.mPersonPolymericData);
            sendMessage(personPolymericReqMsg);
        }
    }

    public void cK(long j) {
        if (i.fZ()) {
            long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j != c && TbadkCoreApplication.isLogin()) {
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
                userMuteCheckCustomMessage.userIdF = c;
                userMuteCheckCustomMessage.userIdT = j;
                userMuteCheckCustomMessage.mId = this.unique_id;
                userMuteCheckCustomMessage.setTag(this.unique_id);
                sendMessage(userMuteCheckCustomMessage);
            }
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.pageIndex = 1;
        this.mPersonPolymericData.aWi();
    }

    public boolean hasMoreData() {
        return this.mPersonPolymericData.hasMore();
    }
}
