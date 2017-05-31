package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class y extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> on;
        ak akVar;
        boolean z;
        boolean z2;
        ak akVar2;
        int i;
        ak akVar3;
        ak akVar4;
        int i2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (on = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).on()) != null && on.size() != 0) {
            akVar = this.this$0.fGm;
            akVar.ad(on);
            z = this.this$0.fGi;
            if (z) {
                akVar4 = this.this$0.fGm;
                FragmentTabHost bka = akVar4.bka();
                i2 = this.this$0.fGh;
                bka.setCurrentTabByType(i2);
            } else {
                z2 = this.this$0.fGD;
                if (z2) {
                    akVar2 = this.this$0.fGm;
                    FragmentTabHost bka2 = akVar2.bka();
                    i = this.this$0.dVd;
                    bka2.setCurrentTabByType(i);
                } else {
                    this.this$0.Y(this.this$0.getIntent());
                }
            }
            this.this$0.fGi = false;
            akVar3 = this.this$0.fGm;
            akVar3.bjZ();
        }
    }
}
