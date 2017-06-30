package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
class b extends CustomMessageListener {
    final /* synthetic */ SelectFriendActivity dtk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.dtk = selectFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            if (contacts.size() > 0) {
                yVar2 = this.dtk.mNoDataView;
                yVar2.setVisibility(8);
                this.dtk.dtf.setContacts(contacts);
                this.dtk.dtf.notifyDataSetChanged();
                return;
            }
            yVar = this.dtk.mNoDataView;
            yVar.setVisibility(0);
        }
    }
}
