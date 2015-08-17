package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ SelectFriendActivity bJV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.bJV = selectFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        u uVar;
        u uVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            if (contacts.size() > 0) {
                uVar2 = this.bJV.mNoDataView;
                uVar2.setVisibility(8);
                this.bJV.bJS.setContacts(contacts);
                this.bJV.bJS.notifyDataSetChanged();
                return;
            }
            uVar = this.bJV.mNoDataView;
            uVar.setVisibility(0);
        }
    }
}
