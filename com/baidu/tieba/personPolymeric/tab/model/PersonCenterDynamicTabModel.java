package com.baidu.tieba.personPolymeric.tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes24.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    private MetaData eKe;
    private TbPageContext eNx;
    private long mUid;
    private User mtI;
    private a mtU;
    private long mCursor = 0;
    private boolean mHasMore = false;
    private final List<by> mThreadDataList = new ArrayList();
    private BdUniqueId mTag = BdUniqueId.gen();
    private final com.baidu.adp.framework.listener.a mtV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647) { // from class: com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            long j;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() == PersonCenterDynamicTabModel.this.mTag) {
                List<by> list = null;
                if (responsedMessage instanceof PersonCenterDynamicTabHttpResMessage) {
                    PersonCenterDynamicTabHttpResMessage personCenterDynamicTabHttpResMessage = (PersonCenterDynamicTabHttpResMessage) responsedMessage;
                    j = personCenterDynamicTabHttpResMessage.mCursor;
                    z = personCenterDynamicTabHttpResMessage.mHasMore;
                    list = personCenterDynamicTabHttpResMessage.mThreadDataList;
                } else if (responsedMessage instanceof PersonCenterDynamicTabSocketResMessage) {
                    PersonCenterDynamicTabSocketResMessage personCenterDynamicTabSocketResMessage = (PersonCenterDynamicTabSocketResMessage) responsedMessage;
                    j = personCenterDynamicTabSocketResMessage.mCursor;
                    z = personCenterDynamicTabSocketResMessage.mHasMore;
                    list = personCenterDynamicTabSocketResMessage.mThreadDataList;
                } else {
                    z = false;
                    j = 0;
                }
                if (responsedMessage.getError() != 0) {
                    if (PersonCenterDynamicTabModel.this.mtU != null) {
                        PersonCenterDynamicTabModel.this.mtU.wK(PersonCenterDynamicTabModel.this.mCursor == 0);
                        return;
                    }
                    return;
                }
                if (!y.isEmpty(list)) {
                    PersonCenterDynamicTabModel.this.fB(list);
                    PersonCenterDynamicTabModel.this.mThreadDataList.addAll(list);
                }
                PersonCenterDynamicTabModel.this.mHasMore = z;
                if (PersonCenterDynamicTabModel.this.mtU != null) {
                    PersonCenterDynamicTabModel.this.mtU.b(PersonCenterDynamicTabModel.this.mThreadDataList, PersonCenterDynamicTabModel.this.mHasMore, PersonCenterDynamicTabModel.this.mCursor == 0);
                }
                PersonCenterDynamicTabModel.this.mCursor = j;
            }
        }
    };

    /* loaded from: classes24.dex */
    public interface a {
        void b(List<by> list, boolean z, boolean z2);

        void wK(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        this.eNx = tbPageContext;
        this.mUid = j;
        this.mtV.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.mtV);
    }

    public void VC() {
        this.mCursor = 0L;
        this.mThreadDataList.clear();
        hz(this.mCursor);
    }

    public void bSp() {
        hz(this.mCursor);
    }

    private void hz(long j) {
        PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.mUid, j, 10);
        personCenterDynamicTabRequestMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(List<by> list) {
        if (this.mtI != null && !y.isEmpty(list)) {
            for (by byVar : list) {
                if (byVar.boP() != null) {
                    byVar.boP().getNewGodData().parserProtobuf(this.mtI.new_god_data);
                    byVar.boP().getBazhuGradeData().parserProtobuf(this.mtI.bazhu_grade);
                    byVar.boP().setBaijiahaoInfo(this.mtI.baijiahao_info);
                    if (this.eKe != null) {
                        byVar.boP().setPrivSetsData(this.eKe.getPrivSetsData());
                    }
                    byVar.bpo();
                }
            }
        }
    }

    public void onDestroy() {
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList.clear();
        if (this.mtV != null) {
            MessageManager.getInstance().unRegisterListener(this.mtV);
        }
    }

    public void a(a aVar) {
        this.mtU = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void d(User user) {
        this.mtI = user;
        VC();
    }

    public void a(MetaData metaData) {
        this.eKe = metaData;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
