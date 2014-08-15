package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends CustomMessageListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce(cd cdVar, int i) {
        super(i);
        this.a = cdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        PersonFriendActivity f;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001186) {
            z = this.a.j;
            if (z) {
                com.baidu.tieba.data.am personListData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonListData();
                f = this.a.f();
                if (f != null) {
                    this.a.k = personListData;
                    this.a.a(personListData, true);
                }
            }
        }
    }
}
