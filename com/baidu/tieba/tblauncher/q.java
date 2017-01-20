package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> od;
        aa aaVar;
        boolean z;
        aa aaVar2;
        aa aaVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (od = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).od()) != null && od.size() != 0) {
            aaVar = this.this$0.ftN;
            aaVar.ae(od);
            z = this.this$0.ftK;
            if (z) {
                aaVar3 = this.this$0.ftN;
                FragmentTabHost bjB = aaVar3.bjB();
                i = this.this$0.ftJ;
                bjB.setCurrentTabByType(i);
            } else {
                this.this$0.z(this.this$0.getIntent());
            }
            this.this$0.ftK = false;
            aaVar2 = this.this$0.ftN;
            aaVar2.bjz();
        }
    }
}
