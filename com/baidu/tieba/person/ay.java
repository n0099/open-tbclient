package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends CustomMessageListener {
    final /* synthetic */ ax dtv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i) {
        super(i);
        this.dtv = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity aBv;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.dtv.bIP;
            if (z) {
                com.baidu.tieba.person.data.r personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                aBv = this.dtv.aBv();
                if (aBv != null) {
                    this.dtv.dtp = personListData;
                    this.dtv.a(personListData, true);
                }
            }
        }
    }
}
