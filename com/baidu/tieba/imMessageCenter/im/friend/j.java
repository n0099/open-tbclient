package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity dqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.dqJ = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        p pVar;
        p pVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            this.dqJ.isLoaded = true;
            atomicBoolean = this.dqJ.dqH;
            atomicBoolean.set(false);
            InviteFriendListActivity inviteFriendListActivity = this.dqJ;
            pVar = this.dqJ.dqC;
            inviteFriendListActivity.hideLoadingView(pVar.getRootView());
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.dqJ.dqE = contacts;
            pVar2 = this.dqJ.dqC;
            if (pVar2 != null) {
                this.dqJ.ayt();
            }
        }
    }
}
