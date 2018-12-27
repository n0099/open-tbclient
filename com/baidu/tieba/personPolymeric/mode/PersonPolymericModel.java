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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.c;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes3.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;
    private CustomMessageListener fWK;
    private CustomMessageListener fWL;
    private CustomMessageListener fWM;
    private b gBw;
    private a gBx;
    private com.baidu.adp.framework.listener.a gBy;
    private CustomMessageListener guW;
    private com.baidu.tieba.personPolymeric.c.a gzY;
    private int gzj;
    private String gzk;
    private boolean isHost;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.gzj = -1;
        this.gzk = "";
        this.gBy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        c cVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            cVar = (ProfileHttpResponseMessage) responsedMessage;
                        }
                        if (cVar.getErrorCode() == 0) {
                            PersonPolymericModel.this.gzY.a(cVar);
                        }
                        if (responsedMessage.getError() == 0) {
                            PersonPolymericModel.this.gBw.b(PersonPolymericModel.this.gzY);
                        } else {
                            PersonPolymericModel.this.gBw.b(null);
                        }
                    }
                }
            }
        };
        this.fWM = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                    DataRes dataRes = aVar.hCH;
                    if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                        if (dataRes.is_mute.equals("0")) {
                            PersonPolymericModel.this.gzj = 0;
                            PersonPolymericModel.this.gzk = dataRes.mute_confirm;
                            if (ao.isEmpty(PersonPolymericModel.this.gzk)) {
                                PersonPolymericModel.this.gzk = "确定禁言？";
                            }
                        } else if (dataRes.is_mute.equals("1")) {
                            PersonPolymericModel.this.gzj = 1;
                        }
                        PersonPolymericModel.this.gBx.a(0, PersonPolymericModel.this.gzj, PersonPolymericModel.this.gzk, aVar.error, aVar.errorString);
                    }
                }
            }
        };
        this.fWK = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        PersonPolymericModel.this.gzj = 1;
                    }
                    PersonPolymericModel.this.gBx.a(1, PersonPolymericModel.this.gzj, PersonPolymericModel.this.gzk, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
                }
            }
        };
        this.fWL = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    PersonPolymericModel.this.gzj = 0;
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    PersonPolymericModel.this.gBx.a(2, PersonPolymericModel.this.gzj, PersonPolymericModel.this.gzk, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
                }
            }
        };
        this.guW = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.5
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
            registerListener(this.fWM);
            registerListener(this.fWK);
            registerListener(this.fWL);
        } else {
            registerListener(this.guW);
        }
        this.isHost = z;
        registerListener(this.gBy);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gzY = aVar;
    }

    public void a(b bVar) {
        this.gBw = bVar;
    }

    public void a(a aVar) {
        this.gBx = aVar;
    }

    public void db(long j) {
        if (j.kK()) {
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

    public void dc(long j) {
        if (j.kK()) {
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
        this.gzY.brf();
    }

    public com.baidu.tieba.personPolymeric.c.a brl() {
        return this.gzY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.gzY != null && this.gzY.getUserData() != null && this.isHost && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            db(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void destroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }
}
