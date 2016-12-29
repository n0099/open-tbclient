package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class t extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> oj;
        ad adVar;
        boolean z;
        ad adVar2;
        ad adVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (oj = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).oj()) != null && oj.size() != 0) {
            adVar = this.this$0.fkF;
            adVar.Z(oj);
            z = this.this$0.fkC;
            if (z) {
                adVar3 = this.this$0.fkF;
                FragmentTabHost bhT = adVar3.bhT();
                i = this.this$0.fkB;
                bhT.setCurrentTabByType(i);
            } else {
                this.this$0.z(this.this$0.getIntent());
            }
            this.this$0.fkC = false;
            adVar2 = this.this$0.fkF;
            adVar2.bhR();
        }
    }
}
