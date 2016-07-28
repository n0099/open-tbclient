package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> nk;
        ab abVar;
        boolean z;
        ab abVar2;
        ab abVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (nk = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).nk()) != null && nk.size() != 0) {
            abVar = this.this$0.foy;
            abVar.ag(nk);
            z = this.this$0.fot;
            if (z) {
                abVar3 = this.this$0.foy;
                FragmentTabHost bhv = abVar3.bhv();
                i = this.this$0.f1for;
                bhv.setCurrentTabByType(i);
            } else {
                this.this$0.C(this.this$0.getIntent());
            }
            this.this$0.fot = false;
            abVar2 = this.this$0.foy;
            abVar2.bhs();
        }
    }
}
