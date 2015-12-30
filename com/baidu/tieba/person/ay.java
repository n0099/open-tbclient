package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends CustomMessageListener {
    final /* synthetic */ ax cPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i) {
        super(i);
        this.cPw = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aoW;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.cPw.mIsHost;
            if (z) {
                com.baidu.tieba.person.data.p personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aoW = this.cPw.aoW();
                if (aoW != null) {
                    this.cPw.cPq = personListData;
                    this.cPw.a(personListData, true);
                }
            }
        }
    }
}
