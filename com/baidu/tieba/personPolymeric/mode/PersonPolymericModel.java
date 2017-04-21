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
    private int eGR;
    private String eGS;
    private b eIq;
    private a eIr;
    private com.baidu.adp.framework.listener.a eIs;
    private CustomMessageListener elN;
    private CustomMessageListener elO;
    private CustomMessageListener elP;
    private n mPersonPolymericData;
    private int pageIndex;

    public PersonPolymericModel(BaseActivity baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.eGR = -1;
        this.eGS = "";
        this.pageIndex = 1;
        this.eIs = new c(this, CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        this.elP = new d(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.elN = new e(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.elO = new f(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        if (!z) {
            registerListener(this.elP);
            registerListener(this.elN);
            registerListener(this.elO);
        }
        registerListener(this.eIs);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eIq = bVar;
    }

    public void a(a aVar) {
        this.eIr = aVar;
    }

    public boolean hasData() {
        return !x.q(this.mPersonPolymericData.amU());
    }

    public void co(long j) {
        if (i.gY() && this.mPersonPolymericData.hasMore()) {
            PersonPolymericReqMsg personPolymericReqMsg = new PersonPolymericReqMsg();
            personPolymericReqMsg.setUid(j);
            personPolymericReqMsg.setPn(this.pageIndex);
            personPolymericReqMsg.setPersonPolymericData(this.mPersonPolymericData);
            sendMessage(personPolymericReqMsg);
        }
    }

    public void cp(long j) {
        if (i.gY()) {
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
        this.mPersonPolymericData.aSD();
    }

    public boolean RR() {
        return this.mPersonPolymericData.hasMore();
    }
}
