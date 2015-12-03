package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> qJ;
        w wVar;
        boolean z;
        w wVar2;
        int i;
        w wVar3;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (qJ = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).qJ()) != null && qJ.size() != 0) {
            wVar = this.this$0.dCW;
            wVar.R(qJ);
            z = this.this$0.isUserChanged;
            if (!z) {
                z2 = this.this$0.dCR;
                if (!z2) {
                    this.this$0.W(this.this$0.getIntent());
                    this.this$0.isUserChanged = false;
                    this.this$0.dCR = false;
                    wVar3 = this.this$0.dCW;
                    wVar3.aES();
                }
            }
            wVar2 = this.this$0.dCW;
            FragmentTabHost aEU = wVar2.aEU();
            i = this.this$0.dCQ;
            aEU.setCurrentTabByType(i);
            this.this$0.isUserChanged = false;
            this.this$0.dCR = false;
            wVar3 = this.this$0.dCW;
            wVar3.aES();
        }
    }
}
