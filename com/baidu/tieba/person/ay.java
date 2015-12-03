package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends CustomMessageListener {
    final /* synthetic */ ax cLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i) {
        super(i);
        this.cLg = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity anL;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.cLg.mIsHost;
            if (z) {
                com.baidu.tieba.person.data.n personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                anL = this.cLg.anL();
                if (anL != null) {
                    this.cLg.cLa = personListData;
                    this.cLg.a(personListData, true);
                }
            }
        }
    }
}
