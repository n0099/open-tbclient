package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends CustomMessageListener {
    final /* synthetic */ bc bSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i) {
        super(i);
        this.bSZ = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aey;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.bSZ.mIsHost;
            if (z) {
                com.baidu.tieba.person.a.a personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aey = this.bSZ.aey();
                if (aey != null) {
                    this.bSZ.bSU = personListData;
                    this.bSZ.a(personListData, true);
                }
            }
        }
    }
}
