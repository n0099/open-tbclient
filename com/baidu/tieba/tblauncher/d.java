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
        ArrayList<com.baidu.tbadk.mainTab.b> of;
        ac acVar;
        boolean z;
        ac acVar2;
        ac acVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (of = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).of()) != null && of.size() != 0) {
            acVar = this.this$0.fwr;
            acVar.af(of);
            z = this.this$0.fwm;
            if (z) {
                acVar3 = this.this$0.fwr;
                FragmentTabHost bkZ = acVar3.bkZ();
                i = this.this$0.fwl;
                bkZ.setCurrentTabByType(i);
            } else {
                this.this$0.C(this.this$0.getIntent());
            }
            this.this$0.fwm = false;
            acVar2 = this.this$0.fwr;
            acVar2.bkW();
        }
    }
}
