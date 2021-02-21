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
import com.baidu.tbadk.n.k;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.personCenter.c.f;
/* loaded from: classes2.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;
    public boolean mIsDataLoaded;
    private f muE;
    private a muF;
    private boolean muG;
    private com.baidu.adp.framework.listener.a muH;
    private CustomMessageListener muI;

    /* loaded from: classes2.dex */
    public interface a {
        void a(f fVar);

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.muG = false;
        this.muH = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(final ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0) {
                            PersonCenterModel.this.muF.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                        } else {
                            PersonCenterModel.this.mIsDataLoaded = true;
                            PersonCenterModel.this.muF.a(PersonCenterModel.this.muE);
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
        this.muI = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonCenterModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        registerListener(this.muI);
        registerListener(this.muH);
    }

    public void a(a aVar) {
        this.muF = aVar;
    }

    public void wF(boolean z) {
        this.muG = z;
    }

    public void hv(long j) {
        if (!j.isNetworkAvailableForImmediately()) {
            this.muF.onFail(-1, null);
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
            if (this.muG) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            this.muE = new f();
            profileRequestMessage.setPersonCenterData(this.muE);
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
        this.muE = new f();
    }

    public f dwQ() {
        return this.muE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.muE != null && this.muE.getUserData() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            hv(b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        if (k.bEg().isSmallFlow() && com.baidu.tieba.personCenter.a.dwA().getCreateTime() > 0) {
            long refreshTime = com.baidu.tieba.personCenter.a.dwA().getRefreshTime();
            long createTime = com.baidu.tieba.personCenter.a.dwA().getCreateTime();
            long dwB = com.baidu.tieba.personCenter.a.dwA().dwB();
            long j2 = refreshTime + createTime;
            long bfa = com.baidu.tieba.personCenter.a.dwA().bfa();
            if (bfa > 0 && j > bfa) {
                j2 = j - bfa;
            }
            h hVar = new h(1008, z, responsedMessage, 0L, createTime, dwB, false, 0L, 0L, j2);
            if (hVar != null) {
                hVar.bEd();
            }
            com.baidu.tieba.personCenter.a.dwA().setCreateTime(0L);
        }
    }
}
