package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        MainTabActivity mainTabActivity;
        if (customResponsedMessage != null && com.baidu.tbadk.core.b.b.a() == null) {
            ae aeVar = new ae();
            mainTabActivity = this.a.I;
            aeVar.a((i) mainTabActivity);
            com.baidu.tbadk.core.b.b.a(aeVar);
        }
    }
}
