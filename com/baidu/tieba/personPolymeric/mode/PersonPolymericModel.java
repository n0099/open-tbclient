package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.f;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;
    private boolean bvm;
    private CustomMessageListener eIo;
    private CustomMessageListener eIp;
    private CustomMessageListener eIq;
    private int fiS;
    private String fiT;
    private CustomMessageListener fjC;
    private com.baidu.tieba.personPolymeric.c.a fjx;
    private b fkV;
    private a fkW;
    private com.baidu.adp.framework.listener.a fkX;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.fiS = -1;
        this.fiT = "";
        this.fkX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z2 = true;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        f fVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            fVar = (ProfileHttpResponseMessage) responsedMessage;
                        }
                        if (fVar.getUserGodInfo() == null || (fVar.getUserGodInfo().god_type.intValue() != 2 && fVar.getUserGodInfo().god_type.intValue() != 1)) {
                            z2 = false;
                        }
                        if (fVar.getErrorCode() == 0) {
                            PersonPolymericModel.this.fkV.ks(z2);
                            PersonPolymericModel.this.fjx.a(fVar);
                        }
                        if (responsedMessage.getError() == 0) {
                            PersonPolymericModel.this.fkV.b(PersonPolymericModel.this.fjx);
                        } else {
                            PersonPolymericModel.this.fkV.b(null);
                        }
                    }
                }
            }
        };
        this.eIq = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                    DataRes dataRes = aVar.gva;
                    if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                        if (dataRes.is_mute.equals("0")) {
                            PersonPolymericModel.this.fiS = 0;
                            PersonPolymericModel.this.fiT = dataRes.mute_confirm;
                            if (am.isEmpty(PersonPolymericModel.this.fiT)) {
                                PersonPolymericModel.this.fiT = "确定禁言？";
                            }
                        } else if (dataRes.is_mute.equals("1")) {
                            PersonPolymericModel.this.fiS = 1;
                        }
                        PersonPolymericModel.this.fkW.a(0, PersonPolymericModel.this.fiS, PersonPolymericModel.this.fiT, aVar.error, aVar.errorString);
                    }
                }
            }
        };
        this.eIo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        PersonPolymericModel.this.fiS = 1;
                    }
                    PersonPolymericModel.this.fkW.a(1, PersonPolymericModel.this.fiS, PersonPolymericModel.this.fiT, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
                }
            }
        };
        this.eIp = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    PersonPolymericModel.this.fiS = 0;
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    PersonPolymericModel.this.fkW.a(2, PersonPolymericModel.this.fiS, PersonPolymericModel.this.fiT, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
                }
            }
        };
        this.fjC = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.5
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
            registerListener(this.eIq);
            registerListener(this.eIo);
            registerListener(this.eIp);
        } else {
            registerListener(this.fjC);
        }
        this.bvm = z;
        registerListener(this.fkX);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fjx = aVar;
    }

    public void a(b bVar) {
        this.fkV = bVar;
    }

    public void a(a aVar) {
        this.fkW = aVar;
    }

    public void cr(long j) {
        if (i.gW()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.bvm) {
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

    public void cs(long j) {
        if (i.gW()) {
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
        this.fjx.aYp();
    }

    public com.baidu.tieba.personPolymeric.c.a aYv() {
        return this.fjx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fjx != null && this.fjx.getUserData() != null && this.bvm && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            cr(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
