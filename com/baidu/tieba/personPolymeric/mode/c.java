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
    private int eJm;
    private String eJn;
    private b eKM;
    private a eKN;
    private com.baidu.adp.framework.listener.a eKO;
    private CustomMessageListener epE;
    private CustomMessageListener epF;
    private CustomMessageListener epG;
    private n mPersonPolymericData;
    private int pageIndex;

    public c(BaseActivity baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.eJm = -1;
        this.eJn = "";
        this.pageIndex = 1;
        this.eKO = new d(this, CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        this.epG = new e(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.epE = new f(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.epF = new g(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        if (!z) {
            registerListener(this.epG);
            registerListener(this.epE);
            registerListener(this.epF);
        }
        registerListener(this.eKO);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eKM = bVar;
    }

    public void a(a aVar) {
        this.eKN = aVar;
    }

    public boolean hasData() {
        return !y.t(this.mPersonPolymericData.aph());
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
        this.mPersonPolymericData.aUb();
    }

    public boolean hasMoreData() {
        return this.mPersonPolymericData.hasMore();
    }
}
