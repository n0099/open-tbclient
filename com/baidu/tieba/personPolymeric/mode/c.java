package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.personPolymeric.c.n;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericReqMsg;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e<BaseActivity> {
    private int eHi;
    private String eHj;
    private b eII;
    private a eIJ;
    private com.baidu.adp.framework.listener.a eIK;
    private CustomMessageListener enF;
    private CustomMessageListener enG;
    private CustomMessageListener enH;
    private n mPersonPolymericData;
    private int pageIndex;

    public c(BaseActivity baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.eHi = -1;
        this.eHj = "";
        this.pageIndex = 1;
        this.eIK = new d(this, CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        this.enH = new e(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.enF = new f(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.enG = new g(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        if (!z) {
            registerListener(this.enH);
            registerListener(this.enF);
            registerListener(this.enG);
        }
        registerListener(this.eIK);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eII = bVar;
    }

    public void a(a aVar) {
        this.eIJ = aVar;
    }

    public boolean hasData() {
        return !y.t(this.mPersonPolymericData.aoT());
    }

    public void cI(long j) {
        if (i.fZ() && this.mPersonPolymericData.hasMore()) {
            PersonPolymericReqMsg personPolymericReqMsg = new PersonPolymericReqMsg();
            personPolymericReqMsg.setUid(j);
            personPolymericReqMsg.setPn(this.pageIndex);
            personPolymericReqMsg.setPersonPolymericData(this.mPersonPolymericData);
            sendMessage(personPolymericReqMsg);
        }
    }

    public void cJ(long j) {
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
        this.mPersonPolymericData.aTE();
    }

    public boolean hasMoreData() {
        return this.mPersonPolymericData.hasMore();
    }
}
