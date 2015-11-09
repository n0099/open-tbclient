package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.m;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ SelectFriendActivity bOu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.bOu = selectFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        m mVar;
        m mVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            if (contacts.size() > 0) {
                mVar2 = this.bOu.mNoDataView;
                mVar2.setVisibility(8);
                this.bOu.bOr.setContacts(contacts);
                this.bOu.bOr.notifyDataSetChanged();
                return;
            }
            mVar = this.bOu.mNoDataView;
            mVar.setVisibility(0);
        }
    }
}
