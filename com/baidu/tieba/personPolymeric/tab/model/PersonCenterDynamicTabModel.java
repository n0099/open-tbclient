package com.baidu.tieba.personPolymeric.tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    private MetaData ePn;
    private TbPageContext eSJ;
    private long mUid;
    private a muC;
    private User muq;
    private long mCursor = 0;
    private boolean mHasMore = false;
    private final List<bz> mThreadDataList = new ArrayList();
    private BdUniqueId mTag = BdUniqueId.gen();
    private final com.baidu.adp.framework.listener.a muD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647) { // from class: com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            long j;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() == PersonCenterDynamicTabModel.this.mTag) {
                List<bz> list = null;
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
                    if (PersonCenterDynamicTabModel.this.muC != null) {
                        PersonCenterDynamicTabModel.this.muC.wH(PersonCenterDynamicTabModel.this.mCursor == 0);
                        return;
                    }
                    return;
                }
                if (!x.isEmpty(list)) {
                    PersonCenterDynamicTabModel.this.fB(list);
                    PersonCenterDynamicTabModel.this.mThreadDataList.addAll(list);
                }
                PersonCenterDynamicTabModel.this.mHasMore = z;
                if (PersonCenterDynamicTabModel.this.muC != null) {
                    PersonCenterDynamicTabModel.this.muC.b(PersonCenterDynamicTabModel.this.mThreadDataList, PersonCenterDynamicTabModel.this.mHasMore, PersonCenterDynamicTabModel.this.mCursor == 0);
                }
                PersonCenterDynamicTabModel.this.mCursor = j;
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void b(List<bz> list, boolean z, boolean z2);

        void wH(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        this.eSJ = tbPageContext;
        this.mUid = j;
        this.muD.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.muD);
    }

    public void SM() {
        this.mCursor = 0L;
        this.mThreadDataList.clear();
        hu(this.mCursor);
    }

    public void bRa() {
        hu(this.mCursor);
    }

    private void hu(long j) {
        PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.mUid, j, 10);
        personCenterDynamicTabRequestMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(List<bz> list) {
        if (this.muq != null && !x.isEmpty(list)) {
            for (bz bzVar : list) {
                if (bzVar.bnx() != null) {
                    bzVar.bnx().getNewGodData().parserProtobuf(this.muq.new_god_data);
                    bzVar.bnx().getBazhuGradeData().parserProtobuf(this.muq.bazhu_grade);
                    bzVar.bnx().setBaijiahaoInfo(this.muq.baijiahao_info);
                    if (this.ePn != null) {
                        bzVar.bnx().setPrivSetsData(this.ePn.getPrivSetsData());
                    }
                    bzVar.bnV();
                }
            }
        }
    }

    public void onDestroy() {
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList.clear();
        if (this.muD != null) {
            MessageManager.getInstance().unRegisterListener(this.muD);
        }
    }

    public void a(a aVar) {
        this.muC = aVar;
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
        this.muq = user;
        SM();
    }

    public void a(MetaData metaData) {
        this.ePn = metaData;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
