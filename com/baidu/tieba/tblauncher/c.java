package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> qe;
        aa aaVar;
        boolean z;
        aa aaVar2;
        int i;
        aa aaVar3;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (qe = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).qe()) != null && qe.size() != 0) {
            aaVar = this.this$0.etw;
            aaVar.S(qe);
            z = this.this$0.isUserChanged;
            if (!z) {
                z2 = this.this$0.etr;
                if (!z2) {
                    this.this$0.w(this.this$0.getIntent());
                    this.this$0.isUserChanged = false;
                    this.this$0.etr = false;
                    aaVar3 = this.this$0.etw;
                    aaVar3.aVn();
                }
            }
            aaVar2 = this.this$0.etw;
            FragmentTabHost aVp = aaVar2.aVp();
            i = this.this$0.etq;
            aVp.setCurrentTabByType(i);
            this.this$0.isUserChanged = false;
            this.this$0.etr = false;
            aaVar3 = this.this$0.etw;
            aaVar3.aVn();
        }
    }
}
