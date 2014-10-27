package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> sE;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        MainTabActivity mainTabActivity;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (sE = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).sE()) != null && sE.size() != 0) {
            fragmentTabHost = this.this$0.bfz;
            fragmentTabHost.reset();
            Iterator<com.baidu.tbadk.mainTab.b> it = sE.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null) {
                    com.baidu.tbadk.mainTab.d sD = next.sD();
                    MainTabActivity mainTabActivity2 = this.this$0;
                    mainTabActivity = this.this$0.bOO;
                    mainTabActivity2.a(sD, next.z(mainTabActivity));
                }
            }
            fragmentTabHost2 = this.this$0.bfz;
            fragmentTabHost2.initViewPager();
            this.this$0.o(this.this$0.getIntent());
        }
    }
}
