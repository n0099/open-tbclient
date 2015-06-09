package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> AG;
        aj ajVar;
        boolean z;
        aj ajVar2;
        int i;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (AG = ((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).AG()) != null && AG.size() != 0) {
            ajVar = this.this$0.cvs;
            ajVar.V(AG);
            z = this.this$0.cvm;
            if (!z) {
                z2 = this.this$0.cvn;
                if (!z2) {
                    this.this$0.W(this.this$0.getIntent());
                    this.this$0.cvm = false;
                    this.this$0.cvn = false;
                }
            }
            ajVar2 = this.this$0.cvs;
            FragmentTabHost aqv = ajVar2.aqv();
            i = this.this$0.cvl;
            aqv.setCurrentTabByType(i);
            this.this$0.cvm = false;
            this.this$0.cvn = false;
        }
    }
}
