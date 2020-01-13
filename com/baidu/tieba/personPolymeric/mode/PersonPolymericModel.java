package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.c;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes9.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;
    private CustomMessageListener iGR;
    private CustomMessageListener iGS;
    private CustomMessageListener iGT;
    private boolean isHost;
    private com.baidu.tieba.personPolymeric.c.a jmS;
    private int jmc;
    private String jmd;
    private b joU;
    private a joV;
    private com.baidu.adp.framework.listener.a joW;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.jmc = -1;
        this.jmd = "";
        this.joW = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        c cVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            cVar = (ProfileHttpResponseMessage) responsedMessage;
                        }
                        if (cVar.getErrorCode() == 0) {
                            PersonPolymericModel.this.jmS.a(cVar);
                        }
                        if (responsedMessage.getError() == 0) {
                            PersonPolymericModel.this.joU.c(PersonPolymericModel.this.jmS);
                        } else {
                            PersonPolymericModel.this.joU.c(null);
                        }
                    }
                }
            }
        };
        this.iGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                    DataRes dataRes = aVar.ktC;
                    if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                        if (dataRes.is_mute.equals("0")) {
                            PersonPolymericModel.this.jmc = 0;
                            PersonPolymericModel.this.jmd = dataRes.mute_confirm;
                            if (aq.isEmpty(PersonPolymericModel.this.jmd)) {
                                PersonPolymericModel.this.jmd = "确定禁言？";
                            }
                        } else if (dataRes.is_mute.equals("1")) {
                            PersonPolymericModel.this.jmc = 1;
                        }
                        PersonPolymericModel.this.joV.a(0, PersonPolymericModel.this.jmc, PersonPolymericModel.this.jmd, aVar.error, aVar.errorString);
                    }
                }
            }
        };
        this.iGR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        PersonPolymericModel.this.jmc = 1;
                    }
                    PersonPolymericModel.this.joV.a(1, PersonPolymericModel.this.jmc, PersonPolymericModel.this.jmd, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
                }
            }
        };
        this.iGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    PersonPolymericModel.this.jmc = 0;
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    PersonPolymericModel.this.joV.a(2, PersonPolymericModel.this.jmc, PersonPolymericModel.this.jmd, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
                }
            }
        };
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.iGT);
            registerListener(this.iGR);
            registerListener(this.iGS);
        }
        this.isHost = z;
        registerListener(this.joW);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jmS = aVar;
    }

    public void a(b bVar) {
        this.joU = bVar;
    }

    public void a(a aVar) {
        this.joV = aVar;
    }

    public void ew(long j) {
        if (j.isNetworkAvailableForImmediately()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)));
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

    public void ex(long j) {
        if (j.isNetworkAvailableForImmediately()) {
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j != j2 && TbadkCoreApplication.isLogin()) {
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
                userMuteCheckCustomMessage.userIdF = j2;
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
        this.jmS.cvI();
    }

    public com.baidu.tieba.personPolymeric.c.a cwd() {
        return this.jmS;
    }

    public void destroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }
}
