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
        ArrayList<com.baidu.tbadk.mainTab.b> sG;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        MainTabActivity mainTabActivity;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (sG = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).sG()) != null && sG.size() != 0) {
            fragmentTabHost = this.this$0.bfN;
            fragmentTabHost.reset();
            Iterator<com.baidu.tbadk.mainTab.b> it = sG.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null) {
                    com.baidu.tbadk.mainTab.d sF = next.sF();
                    MainTabActivity mainTabActivity2 = this.this$0;
                    mainTabActivity = this.this$0.bPd;
                    mainTabActivity2.a(sF, next.z(mainTabActivity));
                }
            }
            fragmentTabHost2 = this.this$0.bfN;
            fragmentTabHost2.initViewPager();
            this.this$0.o(this.this$0.getIntent());
        }
    }
}
