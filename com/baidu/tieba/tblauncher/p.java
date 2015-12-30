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
        ArrayList<com.baidu.tbadk.mainTab.b> qs;
        w wVar;
        boolean z;
        w wVar2;
        int i;
        w wVar3;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (qs = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).qs()) != null && qs.size() != 0) {
            wVar = this.this$0.dKy;
            wVar.Q(qs);
            z = this.this$0.isUserChanged;
            if (!z) {
                z2 = this.this$0.dKt;
                if (!z2) {
                    this.this$0.V(this.this$0.getIntent());
                    this.this$0.isUserChanged = false;
                    this.this$0.dKt = false;
                    wVar3 = this.this$0.dKy;
                    wVar3.aHg();
                }
            }
            wVar2 = this.this$0.dKy;
            FragmentTabHost aHi = wVar2.aHi();
            i = this.this$0.dKs;
            aHi.setCurrentTabByType(i);
            this.this$0.isUserChanged = false;
            this.this$0.dKt = false;
            wVar3 = this.this$0.dKy;
            wVar3.aHg();
        }
    }
}
