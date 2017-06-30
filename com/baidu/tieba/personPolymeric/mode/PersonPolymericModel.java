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
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
/* loaded from: classes.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;
    private boolean boT;
    private int eUR;
    private String eUS;
    private CustomMessageListener eVA;
    private com.baidu.tieba.personPolymeric.c.a eVv;
    private b eWR;
    private a eWS;
    private com.baidu.adp.framework.listener.a eWT;
    private CustomMessageListener evI;
    private CustomMessageListener evJ;
    private CustomMessageListener evK;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.eUR = -1;
        this.eUS = "";
        this.eWT = new c(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.evK = new d(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.evI = new e(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.evJ = new f(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        this.eVA = new g(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.evK);
            registerListener(this.evI);
            registerListener(this.evJ);
        } else {
            registerListener(this.eVA);
        }
        this.boT = z;
        registerListener(this.eWT);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.eVv = aVar;
    }

    public void a(b bVar) {
        this.eWR = bVar;
    }

    public void a(a aVar) {
        this.eWS = aVar;
    }

    public void cs(long j) {
        if (com.baidu.adp.lib.util.i.gX()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.boT) {
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
            profileRequestMessage.setTag(this.unique_id);
            sendMessage(profileRequestMessage);
        }
    }

    public void ct(long j) {
        if (com.baidu.adp.lib.util.i.gX()) {
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
        this.eVv.aVw();
    }

    public com.baidu.tieba.personPolymeric.c.a aVB() {
        return this.eVv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.eVv != null && this.eVv.getUserData() != null && this.boT && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            cs(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
