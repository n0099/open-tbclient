package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends CustomMessageListener {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, int i) {
        super(i);
        this.bHX = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aaX;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.bHX.mIsHost;
            if (z) {
                com.baidu.tbadk.core.data.r personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aaX = this.bHX.aaX();
                if (aaX != null) {
                    this.bHX.bHS = personListData;
                    this.bHX.a(personListData, true);
                }
            }
        }
    }
}
