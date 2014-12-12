package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends CustomMessageListener {
    final /* synthetic */ am bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(am amVar, int i) {
        super(i);
        this.bGm = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aas;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.bGm.mIsHost;
            if (z) {
                com.baidu.tbadk.core.data.q personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aas = this.bGm.aas();
                if (aas != null) {
                    this.bGm.bGh = personListData;
                    this.bGm.a(personListData, true);
                }
            }
        }
    }
}
