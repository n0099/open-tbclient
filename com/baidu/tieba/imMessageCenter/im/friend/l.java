package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity bsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bsz = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        t tVar;
        t tVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            this.bsz.isLoaded = true;
            atomicBoolean = this.bsz.bsx;
            atomicBoolean.set(false);
            InviteFriendListActivity inviteFriendListActivity = this.bsz;
            tVar = this.bsz.bss;
            inviteFriendListActivity.hideLoadingView(tVar.getRootView());
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.bsz.bsu = contacts;
            tVar2 = this.bsz.bss;
            if (tVar2 != null) {
                this.bsz.Vu();
            }
        }
    }
}
