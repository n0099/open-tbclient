package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends CustomMessageListener {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ay ayVar, int i) {
        super(i);
        this.dwQ = ayVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aBU;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.dwQ.bIW;
            if (z) {
                com.baidu.tbadk.core.data.af personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aBU = this.dwQ.aBU();
                if (aBU != null) {
                    this.dwQ.dwK = personListData;
                    this.dwQ.a(personListData, true);
                }
            }
        }
    }
}
