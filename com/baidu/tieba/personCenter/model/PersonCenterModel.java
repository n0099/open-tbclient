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
/* loaded from: classes22.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;
    private f lWj;
    private a lWk;
    private boolean lWl;
    private com.baidu.adp.framework.listener.a lWm;
    private CustomMessageListener lWn;
    public boolean mIsDataLoaded;

    /* loaded from: classes22.dex */
    public interface a {
        void a(f fVar);

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.lWl = false;
        this.lWm = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(final ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage.getError() != 0) {
                            PersonCenterModel.this.lWk.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                        } else {
                            PersonCenterModel.this.mIsDataLoaded = true;
                            PersonCenterModel.this.lWk.a(PersonCenterModel.this.lWj);
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
        this.lWn = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personCenter.model.PersonCenterModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    PersonCenterModel.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        setUniqueId(bdUniqueId);
        registerListener(this.lWn);
        registerListener(this.lWm);
    }

    public void a(a aVar) {
        this.lWk = aVar;
    }

    public void vK(boolean z) {
        this.lWl = z;
    }

    public void gN(long j) {
        if (!j.isNetworkAvailableForImmediately()) {
            this.lWk.onFail(-1, null);
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
            if (this.lWl) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            this.lWj = new f();
            profileRequestMessage.setPersonCenterData(this.lWj);
            sendMessage(profileRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        gN(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void resetData() {
        this.lWj = new f();
    }

    public f dtJ() {
        return this.lWj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.lWj != null && this.lWj.getUserData() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            resetData();
            gN(b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        if (m.bCu().bCv() && com.baidu.tieba.personCenter.a.dtt().getCreateTime() > 0) {
            long refreshTime = com.baidu.tieba.personCenter.a.dtt().getRefreshTime();
            long createTime = com.baidu.tieba.personCenter.a.dtt().getCreateTime();
            long dtu = com.baidu.tieba.personCenter.a.dtt().dtu();
            long j2 = refreshTime + createTime;
            long bdL = com.baidu.tieba.personCenter.a.dtt().bdL();
            if (bdL > 0 && j > bdL) {
                j2 = j - bdL;
            }
            i iVar = new i(1008, z, responsedMessage, 0L, createTime, dtu, false, 0L, 0L, j2);
            if (iVar != null) {
                iVar.bCr();
            }
            com.baidu.tieba.personCenter.a.dtt().setCreateTime(0L);
        }
    }
}
