package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends CustomMessageListener {
    final /* synthetic */ av cjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(av avVar, int i) {
        super(i);
        this.cjG = avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity agq;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.cjG.mIsHost;
            if (z) {
                com.baidu.tieba.person.a.a personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                agq = this.cjG.agq();
                if (agq != null) {
                    this.cjG.cjA = personListData;
                    this.cjG.a(personListData, true);
                }
            }
        }
    }
}
