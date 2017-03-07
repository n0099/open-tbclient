package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.base.BdBaseModel;
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
public class PersonPolymericModel extends BdBaseModel<BaseActivity> {
    private int eGF;
    private String eGG;
    private b eIf;
    private a eIg;
    private com.baidu.adp.framework.listener.a eIh;
    private CustomMessageListener elr;
    private CustomMessageListener els;
    private CustomMessageListener elt;
    private n mPersonPolymericData;
    private int pageIndex;

    public PersonPolymericModel(BaseActivity baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.eGF = -1;
        this.eGG = "";
        this.pageIndex = 1;
        this.eIh = new c(this, CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        this.elt = new d(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.elr = new e(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.els = new f(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        if (!z) {
            registerListener(this.elt);
            registerListener(this.elr);
            registerListener(this.els);
        }
        registerListener(this.eIh);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eIf = bVar;
    }

    public void a(a aVar) {
        this.eIg = aVar;
    }

    public boolean hasData() {
        return !x.q(this.mPersonPolymericData.alZ());
    }

    public void co(long j) {
        if (i.gS() && this.mPersonPolymericData.hasMore()) {
            PersonPolymericReqMsg personPolymericReqMsg = new PersonPolymericReqMsg();
            personPolymericReqMsg.setUid(j);
            personPolymericReqMsg.setPn(this.pageIndex);
            personPolymericReqMsg.setPersonPolymericData(this.mPersonPolymericData);
            sendMessage(personPolymericReqMsg);
        }
    }

    public void cp(long j) {
        if (i.gS()) {
            long c = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
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

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.pageIndex = 1;
        this.mPersonPolymericData.aRt();
    }

    public boolean Qr() {
        return this.mPersonPolymericData.hasMore();
    }
}
