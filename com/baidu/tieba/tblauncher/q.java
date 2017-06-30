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
        ArrayList<com.baidu.tbadk.mainTab.b> oj;
        ad adVar;
        boolean z;
        ad adVar2;
        ad adVar3;
        ad adVar4;
        ad adVar5;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (oj = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).oj()) != null && oj.size() != 0) {
            adVar = this.this$0.fQq;
            adVar.af(oj);
            z = this.this$0.fQn;
            if (z) {
                adVar5 = this.this$0.fQq;
                FragmentTabHost bom = adVar5.bom();
                i = this.this$0.fQm;
                bom.setCurrentTabByType(i);
            } else {
                this.this$0.Y(this.this$0.getIntent());
            }
            this.this$0.fQn = false;
            adVar2 = this.this$0.fQq;
            adVar2.bol();
            int size = oj.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (oj.get(i2) != null && oj.get(i2).Ez() != null && 15 == oj.get(i2).Ez().type) {
                    adVar3 = this.this$0.fQq;
                    if (adVar3 != null) {
                        adVar4 = this.this$0.fQq;
                        adVar4.boo();
                        return;
                    }
                    return;
                }
            }
        }
    }
}
