package com.baidu.tieba.personCenter.model;

import android.os.Looper;
import android.os.MessageQueue;
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
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.personCenter.c.f;
/* loaded from: classes9.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;
    private f kmR;
    private a kmS;
    private boolean kmT;
    private com.baidu.adp.framework.listener.a kmU;
    private CustomMessageListener kmV;
    public boolean mIsDataLoaded;

    /* loaded from: classes9.dex */
    public interface a {
        void a(f fVar);

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.kmT = false;
        this.kmU = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(final ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0) {
                            PersonCenterModel.this.kmS.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                        } else {
                            PersonCenterModel.this.mIsDataLoaded = true;
                            PersonCenterModel.this.kmS.a(PersonCenterModel.this.kmR);
                        }
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            final long currentTimeMillis = System.currentTimeMillis();
                            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1.1
                                @Override // android.os.MessageQueue.IdleHandler
                                public boolean queueIdle() {
                                    PersonCenterModel.this.a(true, responsedMessage, currentTimeMillis);
                                    return false;
                                }
                            });
                        }
                    }
                }
            }
        };
        this.kmV = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonCenterModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        registerListener(this.kmV);
        registerListener(this.kmU);
    }

    public void a(a aVar) {
        this.kmS = aVar;
    }

    public void sP(boolean z) {
        this.kmT = z;
    }

    public void fh(long j) {
        if (!j.isNetworkAvailableForImmediately()) {
            this.kmS.onFail(-1, null);
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
            if (this.kmT) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            this.kmR = new f();
            profileRequestMessage.setPersonCenterData(this.kmR);
            sendMessage(profileRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        fh(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.kmR = new f();
    }

    public f cNF() {
        return this.kmR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.kmR != null && this.kmR.getUserData() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            fh(b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        if (m.bfJ().bfK() && com.baidu.tieba.personCenter.a.cNr().getCreateTime() > 0) {
            long refreshTime = com.baidu.tieba.personCenter.a.cNr().getRefreshTime();
            long createTime = com.baidu.tieba.personCenter.a.cNr().getCreateTime();
            long cNs = com.baidu.tieba.personCenter.a.cNr().cNs();
            long j2 = refreshTime + createTime;
            long aIA = com.baidu.tieba.personCenter.a.cNr().aIA();
            if (aIA > 0 && j > aIA) {
                j2 = j - aIA;
            }
            i iVar = new i(1008, z, responsedMessage, 0L, createTime, cNs, false, 0L, 0L, j2);
            if (iVar != null) {
                iVar.bfG();
            }
            com.baidu.tieba.personCenter.a.cNr().setCreateTime(0L);
        }
    }
}
