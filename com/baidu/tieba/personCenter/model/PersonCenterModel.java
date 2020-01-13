package com.baidu.tieba.personCenter.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes7.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;
    private f jgS;
    private a jgT;
    private boolean jgU;
    private com.baidu.adp.framework.listener.a jgV;
    private CustomMessageListener jgW;
    public boolean mIsDataLoaded;

    /* loaded from: classes7.dex */
    public interface a {
        void a(f fVar);

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.jgU = false;
        this.jgV = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0) {
                            PersonCenterModel.this.jgT.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                            return;
                        }
                        PersonCenterModel.this.mIsDataLoaded = true;
                        PersonCenterModel.this.jgT.a(PersonCenterModel.this.jgS);
                    }
                }
            }
        };
        this.jgW = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonCenterModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        registerListener(this.jgW);
        registerListener(this.jgV);
    }

    public void a(a aVar) {
        this.jgT = aVar;
    }

    public void rd(boolean z) {
        this.jgU = z;
    }

    public void ev(long j) {
        if (!j.isNetworkAvailableForImmediately()) {
            this.jgT.onFail(-1, null);
        } else if (TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(this.unique_id);
            if (this.jgU) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            this.jgS = new f();
            profileRequestMessage.setPersonCenterData(this.jgS);
            sendMessage(profileRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        ev(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.jgS = new f();
    }

    public f ctR() {
        return this.jgS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.jgS != null && this.jgS.getUserData() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            ev(b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
