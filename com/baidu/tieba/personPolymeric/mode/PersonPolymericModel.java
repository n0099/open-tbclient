package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.c;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;
    private CustomMessageListener eCr;
    private CustomMessageListener eCs;
    private CustomMessageListener eCt;
    private CustomMessageListener faB;
    private int feO;
    private String feP;
    private com.baidu.tieba.personPolymeric.c.a ffC;
    private b fhk;
    private a fhl;
    private com.baidu.adp.framework.listener.a fhm;
    private boolean isHost;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.feO = -1;
        this.feP = "";
        this.fhm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        c cVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            cVar = (ProfileHttpResponseMessage) responsedMessage;
                        }
                        if (cVar.getErrorCode() == 0) {
                            PersonPolymericModel.this.ffC.a(cVar);
                        }
                        if (responsedMessage.getError() == 0) {
                            PersonPolymericModel.this.fhk.b(PersonPolymericModel.this.ffC);
                        } else {
                            PersonPolymericModel.this.fhk.b(null);
                        }
                    }
                }
            }
        };
        this.eCt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                    DataRes dataRes = aVar.gtz;
                    if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                        if (dataRes.is_mute.equals("0")) {
                            PersonPolymericModel.this.feO = 0;
                            PersonPolymericModel.this.feP = dataRes.mute_confirm;
                            if (am.isEmpty(PersonPolymericModel.this.feP)) {
                                PersonPolymericModel.this.feP = "确定禁言？";
                            }
                        } else if (dataRes.is_mute.equals("1")) {
                            PersonPolymericModel.this.feO = 1;
                        }
                        PersonPolymericModel.this.fhl.a(0, PersonPolymericModel.this.feO, PersonPolymericModel.this.feP, aVar.error, aVar.errorString);
                    }
                }
            }
        };
        this.eCr = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        PersonPolymericModel.this.feO = 1;
                    }
                    PersonPolymericModel.this.fhl.a(1, PersonPolymericModel.this.feO, PersonPolymericModel.this.feP, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
                }
            }
        };
        this.eCs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    PersonPolymericModel.this.feO = 0;
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    PersonPolymericModel.this.fhl.a(2, PersonPolymericModel.this.feO, PersonPolymericModel.this.feP, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
                }
            }
        };
        this.faB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonPolymericModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.eCt);
            registerListener(this.eCr);
            registerListener(this.eCs);
        } else {
            registerListener(this.faB);
        }
        this.isHost = z;
        registerListener(this.fhm);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ffC = aVar;
    }

    public void a(b bVar) {
        this.fhk = bVar;
    }

    public void a(a aVar) {
        this.fhl = aVar;
    }

    public void cq(long j) {
        if (j.gV()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.isHost) {
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

    public void cr(long j) {
        if (j.gV()) {
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
        this.ffC.aWU();
    }

    public com.baidu.tieba.personPolymeric.c.a aWY() {
        return this.ffC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.ffC != null && this.ffC.getUserData() != null && this.isHost && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            cq(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
