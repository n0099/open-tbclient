package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ aj bQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(aj ajVar, int i) {
        super(i);
        this.bQe = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity adb;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.bQe.mIsHost;
            if (z) {
                com.baidu.tieba.person.a.a personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                adb = this.bQe.adb();
                if (adb != null) {
                    this.bQe.bPZ = personListData;
                    this.bQe.a(personListData, true);
                }
            }
        }
    }
}
