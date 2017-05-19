package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> ov;
        ah ahVar;
        boolean z;
        ah ahVar2;
        ah ahVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (ov = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).ov()) != null && ov.size() != 0) {
            ahVar = this.this$0.fyv;
            ahVar.ad(ov);
            z = this.this$0.fyr;
            if (z) {
                ahVar3 = this.this$0.fyv;
                FragmentTabHost biC = ahVar3.biC();
                i = this.this$0.fyq;
                biC.setCurrentTabByType(i);
            } else {
                this.this$0.Y(this.this$0.getIntent());
            }
            this.this$0.fyr = false;
            ahVar2 = this.this$0.fyv;
            ahVar2.biB();
        }
    }
}
