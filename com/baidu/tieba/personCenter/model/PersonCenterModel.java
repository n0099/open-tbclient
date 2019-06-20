package com.baidu.tieba.personCenter.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;
    private f iei;
    private a iej;
    private boolean iek;
    private com.baidu.adp.framework.listener.a iel;
    private CustomMessageListener iem;
    public boolean mIsDataLoaded;

    /* loaded from: classes4.dex */
    public interface a {
        void a(f fVar);

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.iek = false;
        this.iel = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0) {
                            PersonCenterModel.this.iej.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                            return;
                        }
                        PersonCenterModel.this.mIsDataLoaded = true;
                        PersonCenterModel.this.iej.a(PersonCenterModel.this.iei);
                    }
                }
            }
        };
        this.iem = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonCenterModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        registerListener(this.iem);
        registerListener(this.iel);
    }

    public void a(a aVar) {
        this.iej = aVar;
    }

    public void pn(boolean z) {
        this.iek = z;
    }

    public void ed(long j) {
        if (!j.jG()) {
            this.iej.onFail(-1, null);
        } else if (TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(this.unique_id);
            if (this.iek) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            this.iei = new f();
            profileRequestMessage.setPersonCenterData(this.iei);
            sendMessage(profileRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        ed(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.iei = new f();
    }

    public f bYx() {
        return this.iei;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.iei != null && this.iei.getUserData() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            ed(b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
