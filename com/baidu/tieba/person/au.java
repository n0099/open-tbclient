package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends CustomMessageListener {
    final /* synthetic */ at bCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(at atVar, int i) {
        super(i);
        this.bCz = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity ZZ;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.bCz.mIsHost;
            if (z) {
                com.baidu.tieba.data.aj personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                ZZ = this.bCz.ZZ();
                if (ZZ != null) {
                    this.bCz.bCt = personListData;
                    this.bCz.a(personListData, true);
                }
            }
        }
    }
}
