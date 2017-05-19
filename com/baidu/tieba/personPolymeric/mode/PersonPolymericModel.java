package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.personPolymeric.c.n;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    private boolean bjW;
    private CustomMessageListener eCD;
    private int eCg;
    private String eCh;
    private b eDT;
    private a eDU;
    private com.baidu.adp.framework.listener.a eDV;
    private CustomMessageListener ehb;
    private CustomMessageListener ehc;
    private CustomMessageListener ehd;
    private n mPersonPolymericData;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.eCg = -1;
        this.eCh = "";
        this.eDV = new c(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.ehd = new d(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.ehb = new e(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.ehc = new f(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        this.eCD = new g(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.ehd);
            registerListener(this.ehb);
            registerListener(this.ehc);
        } else {
            registerListener(this.eCD);
        }
        this.bjW = z;
        registerListener(this.eDV);
        this.mPersonPolymericData = new n(z);
    }

    public void a(b bVar) {
        this.eDT = bVar;
    }

    public void a(a aVar) {
        this.eDU = aVar;
    }

    public void bZ(long j) {
        if (com.baidu.adp.lib.util.i.gY()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.bjW) {
                profileRequestMessage.set_friend_uid(Long.valueOf(j));
                profileRequestMessage.set_is_guest(1);
            }
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            sendMessage(profileRequestMessage);
        }
    }

    public void ca(long j) {
        if (com.baidu.adp.lib.util.i.gY()) {
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
        this.mPersonPolymericData.aPU();
    }

    public n aPY() {
        return this.mPersonPolymericData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.bjW && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            bZ(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
