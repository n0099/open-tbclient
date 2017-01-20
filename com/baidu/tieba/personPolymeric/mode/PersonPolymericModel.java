package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.personPolymeric.c.n;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericReqMsg;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class PersonPolymericModel extends BdBaseModel<BaseActivity> {
    private int eDd;
    private String eDe;
    private b eED;
    private a eEE;
    private com.baidu.adp.framework.listener.a eEF;
    private CustomMessageListener eiA;
    private CustomMessageListener eiy;
    private CustomMessageListener eiz;
    private n mPersonPolymericData;
    private int pageIndex;

    public PersonPolymericModel(BaseActivity baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.eDd = -1;
        this.eDe = "";
        this.pageIndex = 1;
        this.eEF = new c(this, CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        this.eiA = new d(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.eiy = new e(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.eiz = new f(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        if (!z) {
            registerListener(this.eiA);
            registerListener(this.eiy);
            registerListener(this.eiz);
        }
        registerListener(this.eEF);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eED = bVar;
    }

    public void a(a aVar) {
        this.eEE = aVar;
    }

    public boolean hasData() {
        return !w.s(this.mPersonPolymericData.amM());
    }

    public void cm(long j) {
        if (i.fX() && this.mPersonPolymericData.hasMore()) {
            PersonPolymericReqMsg personPolymericReqMsg = new PersonPolymericReqMsg();
            personPolymericReqMsg.setUid(j);
            personPolymericReqMsg.setPn(this.pageIndex);
            personPolymericReqMsg.setPersonPolymericData(this.mPersonPolymericData);
            sendMessage(personPolymericReqMsg);
        }
    }

    public void cn(long j) {
        if (i.fX()) {
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
        this.mPersonPolymericData.aRQ();
    }

    public boolean Py() {
        return this.mPersonPolymericData.hasMore();
    }
}
