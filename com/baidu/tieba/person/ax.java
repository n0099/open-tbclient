package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends CustomMessageListener {
    final /* synthetic */ aw cqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(aw awVar, int i) {
        super(i);
        this.cqq = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aiC;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.cqq.mIsHost;
            if (z) {
                com.baidu.tieba.person.data.a personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aiC = this.cqq.aiC();
                if (aiC != null) {
                    this.cqq.cqk = personListData;
                    this.cqq.a(personListData, true);
                }
            }
        }
    }
}
