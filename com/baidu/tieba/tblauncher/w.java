package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> a;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        MainTabActivity mainTabActivity;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (a = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).a()) != null && a.size() != 0) {
            fragmentTabHost = this.a.n;
            fragmentTabHost.b();
            Iterator<com.baidu.tbadk.mainTab.b> it = a.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null) {
                    com.baidu.tbadk.mainTab.d b = next.b();
                    MainTabActivity mainTabActivity2 = this.a;
                    mainTabActivity = this.a.I;
                    mainTabActivity2.a(b, next.a(mainTabActivity));
                }
            }
            fragmentTabHost2 = this.a.n;
            fragmentTabHost2.a();
            this.a.a(this.a.getIntent());
        }
    }
}
