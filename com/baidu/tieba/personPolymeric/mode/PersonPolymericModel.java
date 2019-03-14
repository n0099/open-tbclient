package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.c;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes6.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;
    private CustomMessageListener hMl;
    private int hQn;
    private String hQo;
    private com.baidu.tieba.personPolymeric.c.a hRc;
    private b hSA;
    private a hSB;
    private com.baidu.adp.framework.listener.a hSC;
    private CustomMessageListener hnT;
    private CustomMessageListener hnU;
    private CustomMessageListener hnV;
    private boolean isHost;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.hQn = -1;
        this.hQo = "";
        this.hSC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        c cVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            cVar = (ProfileHttpResponseMessage) responsedMessage;
                        }
                        if (cVar.getErrorCode() == 0) {
                            PersonPolymericModel.this.hRc.a(cVar);
                        }
                        if (responsedMessage.getError() == 0) {
                            PersonPolymericModel.this.hSA.b(PersonPolymericModel.this.hRc);
                        } else {
                            PersonPolymericModel.this.hSA.b(null);
                        }
                    }
                }
            }
        };
        this.hnV = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                    DataRes dataRes = aVar.iUp;
                    if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                        if (dataRes.is_mute.equals("0")) {
                            PersonPolymericModel.this.hQn = 0;
                            PersonPolymericModel.this.hQo = dataRes.mute_confirm;
                            if (ap.isEmpty(PersonPolymericModel.this.hQo)) {
                                PersonPolymericModel.this.hQo = "确定禁言？";
                            }
                        } else if (dataRes.is_mute.equals("1")) {
                            PersonPolymericModel.this.hQn = 1;
                        }
                        PersonPolymericModel.this.hSB.a(0, PersonPolymericModel.this.hQn, PersonPolymericModel.this.hQo, aVar.error, aVar.errorString);
                    }
                }
            }
        };
        this.hnT = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        PersonPolymericModel.this.hQn = 1;
                    }
                    PersonPolymericModel.this.hSB.a(1, PersonPolymericModel.this.hQn, PersonPolymericModel.this.hQo, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
                }
            }
        };
        this.hnU = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    PersonPolymericModel.this.hQn = 0;
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    PersonPolymericModel.this.hSB.a(2, PersonPolymericModel.this.hQn, PersonPolymericModel.this.hQo, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
                }
            }
        };
        this.hMl = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.5
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
            registerListener(this.hnV);
            registerListener(this.hnT);
            registerListener(this.hnU);
        } else {
            registerListener(this.hMl);
        }
        this.isHost = z;
        registerListener(this.hSC);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hRc = aVar;
    }

    public void a(b bVar) {
        this.hSA = bVar;
    }

    public void a(a aVar) {
        this.hSB = aVar;
    }

    public void dG(long j) {
        if (j.kM()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(2);
            sendMessage(profileRequestMessage);
        }
    }

    public void dH(long j) {
        if (j.kM()) {
            long d = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j != d && TbadkCoreApplication.isLogin()) {
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
                userMuteCheckCustomMessage.userIdF = d;
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
        this.hRc.bSm();
    }

    public com.baidu.tieba.personPolymeric.c.a bSs() {
        return this.hRc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.hRc != null && this.hRc.getUserData() != null && this.isHost && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            dG(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void destroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }
}
