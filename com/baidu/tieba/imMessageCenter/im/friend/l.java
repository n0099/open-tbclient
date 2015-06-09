package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity bvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bvB = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        t tVar;
        t tVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            this.bvB.isLoaded = true;
            atomicBoolean = this.bvB.bvz;
            atomicBoolean.set(false);
            InviteFriendListActivity inviteFriendListActivity = this.bvB;
            tVar = this.bvB.bvu;
            inviteFriendListActivity.hideLoadingView(tVar.getRootView());
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.bvB.bvw = contacts;
            tVar2 = this.bvB.bvu;
            if (tVar2 != null) {
                this.bvB.Xa();
            }
        }
    }
}
