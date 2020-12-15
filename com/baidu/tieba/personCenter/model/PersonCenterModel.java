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
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.l;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.personCenter.c.f;
/* loaded from: classes22.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;
    public boolean mIsDataLoaded;
    private f mkL;
    private a mkM;
    private boolean mkN;
    private com.baidu.adp.framework.listener.a mkO;
    private CustomMessageListener mkP;

    /* loaded from: classes22.dex */
    public interface a {
        void a(f fVar);

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.mkN = false;
        this.mkO = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(final ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0) {
                            PersonCenterModel.this.mkM.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                        } else {
                            PersonCenterModel.this.mIsDataLoaded = true;
                            PersonCenterModel.this.mkM.a(PersonCenterModel.this.mkL);
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
        this.mkP = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonCenterModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        registerListener(this.mkP);
        registerListener(this.mkO);
    }

    public void a(a aVar) {
        this.mkM = aVar;
    }

    public void wr(boolean z) {
        this.mkN = z;
    }

    public void hv(long j) {
        if (!j.isNetworkAvailableForImmediately()) {
            this.mkM.onFail(-1, null);
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
            if (this.mkN) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            this.mkL = new f();
            profileRequestMessage.setPersonCenterData(this.mkL);
            sendMessage(profileRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        hv(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.mkL = new f();
    }

    public f dyC() {
        return this.mkL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mkL != null && this.mkL.getUserData() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            hv(b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        if (l.bFl().isSmallFlow() && com.baidu.tieba.personCenter.a.dym().getCreateTime() > 0) {
            long refreshTime = com.baidu.tieba.personCenter.a.dym().getRefreshTime();
            long createTime = com.baidu.tieba.personCenter.a.dym().getCreateTime();
            long dyn = com.baidu.tieba.personCenter.a.dym().dyn();
            long j2 = refreshTime + createTime;
            long bgj = com.baidu.tieba.personCenter.a.dym().bgj();
            if (bgj > 0 && j > bgj) {
                j2 = j - bgj;
            }
            h hVar = new h(1008, z, responsedMessage, 0L, createTime, dyn, false, 0L, 0L, j2);
            if (hVar != null) {
                hVar.bFi();
            }
            com.baidu.tieba.personCenter.a.dym().setCreateTime(0L);
        }
    }
}
