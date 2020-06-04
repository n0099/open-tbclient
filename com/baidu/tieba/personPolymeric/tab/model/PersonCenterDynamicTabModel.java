package com.baidu.tieba.personPolymeric.tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes11.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    private TbPageContext dIF;
    private a kvB;
    private User kvp;
    private long mUid;
    private long mCursor = 0;
    private boolean mHasMore = false;
    private final List<bk> mThreadDataList = new ArrayList();
    private BdUniqueId mTag = BdUniqueId.gen();
    private final com.baidu.adp.framework.listener.a kvC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647) { // from class: com.baidu.tieba.personPolymeric.tab.model.PersonCenterDynamicTabModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            long j;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() == PersonCenterDynamicTabModel.this.mTag) {
                List<bk> list = null;
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
                    if (PersonCenterDynamicTabModel.this.kvB != null) {
                        PersonCenterDynamicTabModel.this.kvB.tg(PersonCenterDynamicTabModel.this.mCursor == 0);
                        return;
                    }
                    return;
                }
                if (!v.isEmpty(list)) {
                    PersonCenterDynamicTabModel.this.el(list);
                    PersonCenterDynamicTabModel.this.mThreadDataList.addAll(list);
                }
                PersonCenterDynamicTabModel.this.mHasMore = z;
                if (PersonCenterDynamicTabModel.this.kvB != null) {
                    PersonCenterDynamicTabModel.this.kvB.c(PersonCenterDynamicTabModel.this.mThreadDataList, PersonCenterDynamicTabModel.this.mHasMore, PersonCenterDynamicTabModel.this.mCursor == 0);
                }
                PersonCenterDynamicTabModel.this.mCursor = j;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void c(List<bk> list, boolean z, boolean z2);

        void tg(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        this.dIF = tbPageContext;
        this.mUid = j;
        this.kvC.setTag(this.mTag);
        MessageManager.getInstance().registerListener(this.kvC);
    }

    public void Ho() {
        this.mCursor = 0L;
        this.mThreadDataList.clear();
        dH(this.mCursor);
    }

    public void bqZ() {
        dH(this.mCursor);
    }

    private void dH(long j) {
        PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.mUid, j, 10);
        personCenterDynamicTabRequestMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(List<bk> list) {
        if (this.kvp != null && !v.isEmpty(list)) {
            for (bk bkVar : list) {
                if (bkVar.aQx() != null) {
                    bkVar.aQx().getNewGodData().parserProtobuf(this.kvp.new_god_data);
                    bkVar.aQX();
                }
            }
        }
    }

    public void onDestroy() {
        this.mCursor = 0L;
        this.mHasMore = false;
        this.mThreadDataList.clear();
        if (this.kvC != null) {
            MessageManager.getInstance().unRegisterListener(this.kvC);
        }
    }

    public void a(a aVar) {
        this.kvB = aVar;
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
        this.kvp = user;
        Ho();
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
