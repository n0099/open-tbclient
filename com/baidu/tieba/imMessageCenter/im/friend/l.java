package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bsP = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        t tVar;
        t tVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            this.bsP.isLoaded = true;
            atomicBoolean = this.bsP.bsN;
            atomicBoolean.set(false);
            InviteFriendListActivity inviteFriendListActivity = this.bsP;
            tVar = this.bsP.bsI;
            inviteFriendListActivity.hideLoadingView(tVar.getRootView());
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.bsP.bsK = contacts;
            tVar2 = this.bsP.bsI;
            if (tVar2 != null) {
                this.bsP.VH();
            }
        }
    }
}
