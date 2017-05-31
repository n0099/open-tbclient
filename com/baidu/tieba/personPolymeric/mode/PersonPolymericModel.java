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
    private boolean bld;
    private int eKS;
    private String eKT;
    private com.baidu.tieba.personPolymeric.c.a eLr;
    private CustomMessageListener eLw;
    private b eMI;
    private a eMJ;
    private com.baidu.adp.framework.listener.a eMK;
    private CustomMessageListener emE;
    private CustomMessageListener emF;
    private CustomMessageListener emG;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.eKS = -1;
        this.eKT = "";
        this.eMK = new c(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.emG = new d(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
        this.emE = new e(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
        this.emF = new f(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
        this.eLw = new g(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.emG);
            registerListener(this.emE);
            registerListener(this.emF);
        } else {
            registerListener(this.eLw);
        }
        this.bld = z;
        registerListener(this.eMK);
    }

    public void f(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.eLr = aVar;
    }

    public void a(b bVar) {
        this.eMI = bVar;
    }

    public void a(a aVar) {
        this.eMJ = aVar;
    }

    public void cd(long j) {
        if (com.baidu.adp.lib.util.i.gY()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.bld) {
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

    public void ce(long j) {
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
        this.eLr.aRn();
    }

    public com.baidu.tieba.personPolymeric.c.a aRt() {
        return this.eLr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.eLr != null && this.eLr.getUserData() != null && this.bld && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            cd(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
