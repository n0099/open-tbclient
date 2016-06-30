package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity dce;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.dce = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        p pVar;
        p pVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            this.dce.isLoaded = true;
            atomicBoolean = this.dce.dcc;
            atomicBoolean.set(false);
            InviteFriendListActivity inviteFriendListActivity = this.dce;
            pVar = this.dce.dbX;
            inviteFriendListActivity.hideLoadingView(pVar.getRootView());
            List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.dce.dbZ = contacts;
            pVar2 = this.dce.dbX;
            if (pVar2 != null) {
                this.dce.asT();
            }
        }
    }
}
