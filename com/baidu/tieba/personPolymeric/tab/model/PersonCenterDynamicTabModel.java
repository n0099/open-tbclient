package com.baidu.tieba.personPolymeric.tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes23.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    private MetaData eep;
    private TbPageContext ehG;
    private a lxI;
    private User lxw;
    private long mUid;
    private long mCursor = 0;
    private boolean mHasMore = false;
    private final List<bw> mThreadDataList = new ArrayList();
    private BdUniqueId mTag = BdUniqueId.gen();
    private final com.baidu.adp.framework.listener.a lxJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647) { // from class: com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            long j;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() == PersonCenterDynamicTabModel.this.mTag) {
                List<bw> list = null;
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
                    if (PersonCenterDynamicTabModel.this.lxI != null) {
                        PersonCenterDynamicTabModel.this.lxI.uW(PersonCenterDynamicTabModel.this.mCursor == 0);
                        return;
                    }
                    return;
                }
                if (!y.isEmpty(list)) {
                    PersonCenterDynamicTabModel.this.eV(list);
                    PersonCenterDynamicTabModel.this.mThreadDataList.addAll(list);
                }
                PersonCenterDynamicTabModel.this.mHasMore = z;
                if (PersonCenterDynamicTabModel.this.lxI != null) {
                    PersonCenterDynamicTabModel.this.lxI.b(PersonCenterDynamicTabModel.this.mThreadDataList, PersonCenterDynamicTabModel.this.mHasMore, PersonCenterDynamicTabModel.this.mCursor == 0);
                }
                PersonCenterDynamicTabModel.this.mCursor = j;
            }
        }
    };

    /* loaded from: classes23.dex */
    public interface a {
        void b(List<bw> list, boolean z, boolean z2);

        void uW(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        this.ehG = tbPageContext;
        this.mUid = j;
        this.lxJ.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.lxJ);
    }

    public void Pd() {
        this.mCursor = 0L;
        this.mThreadDataList.clear();
        gc(this.mCursor);
    }

    public void bHw() {
        gc(this.mCursor);
    }

    private void gc(long j) {
        PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.mUid, j, 10);
        personCenterDynamicTabRequestMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(List<bw> list) {
        if (this.lxw != null && !y.isEmpty(list)) {
            for (bw bwVar : list) {
                if (bwVar.bfy() != null) {
                    bwVar.bfy().getNewGodData().parserProtobuf(this.lxw.new_god_data);
                    bwVar.bfy().getBazhuGradeData().parserProtobuf(this.lxw.bazhu_grade);
                    bwVar.bfy().setBaijiahaoInfo(this.lxw.baijiahao_info);
                    if (this.eep != null) {
                        bwVar.bfy().setPrivSetsData(this.eep.getPrivSetsData());
                    }
                    bwVar.bfX();
                }
            }
        }
    }

    public void onDestroy() {
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList.clear();
        if (this.lxJ != null) {
            MessageManager.getInstance().unRegisterListener(this.lxJ);
        }
    }

    public void a(a aVar) {
        this.lxI = aVar;
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
        this.lxw = user;
        Pd();
    }

    public void a(MetaData metaData) {
        this.eep = metaData;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
