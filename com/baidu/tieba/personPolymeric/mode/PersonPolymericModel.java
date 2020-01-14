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
    private com.baidu.tieba.personPolymeric.c.a jmX;
    private int jmh;
    private String jmi;
    private b joZ;
    private a jpa;
    private com.baidu.adp.framework.listener.a jpb;

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.jmh = -1;
        this.jmi = "";
        this.jpb = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        c cVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            cVar = (ProfileHttpResponseMessage) responsedMessage;
                        }
                        if (cVar.getErrorCode() == 0) {
                            PersonPolymericModel.this.jmX.a(cVar);
                        }
                        if (responsedMessage.getError() == 0) {
                            PersonPolymericModel.this.joZ.c(PersonPolymericModel.this.jmX);
                        } else {
                            PersonPolymericModel.this.joZ.c(null);
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
                    DataRes dataRes = aVar.ktH;
                    if (aVar.error == 0 && !StringUtils.isNULL(dataRes.is_mute)) {
                        if (dataRes.is_mute.equals("0")) {
                            PersonPolymericModel.this.jmh = 0;
                            PersonPolymericModel.this.jmi = dataRes.mute_confirm;
                            if (aq.isEmpty(PersonPolymericModel.this.jmi)) {
                                PersonPolymericModel.this.jmi = "确定禁言？";
                            }
                        } else if (dataRes.is_mute.equals("1")) {
                            PersonPolymericModel.this.jmh = 1;
                        }
                        PersonPolymericModel.this.jpa.a(0, PersonPolymericModel.this.jmh, PersonPolymericModel.this.jmi, aVar.error, aVar.errorString);
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
                        PersonPolymericModel.this.jmh = 1;
                    }
                    PersonPolymericModel.this.jpa.a(1, PersonPolymericModel.this.jmh, PersonPolymericModel.this.jmi, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
                }
            }
        };
        this.iGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.personPolymeric.mode.PersonPolymericModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                    PersonPolymericModel.this.jmh = 0;
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    PersonPolymericModel.this.jpa.a(2, PersonPolymericModel.this.jmh, PersonPolymericModel.this.jmi, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
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
        registerListener(this.jpb);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jmX = aVar;
    }

    public void a(b bVar) {
        this.joZ = bVar;
    }

    public void a(a aVar) {
        this.jpa = aVar;
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
        this.jmX.cvK();
    }

    public com.baidu.tieba.personPolymeric.c.a cwf() {
        return this.jmX;
    }

    public void destroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }
}
