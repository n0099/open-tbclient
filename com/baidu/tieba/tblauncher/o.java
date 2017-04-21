package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> oO;
        z zVar;
        boolean z;
        z zVar2;
        z zVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (oO = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).oO()) != null && oO.size() != 0) {
            zVar = this.this$0.fCk;
            zVar.ae(oO);
            z = this.this$0.fCh;
            if (z) {
                zVar3 = this.this$0.fCk;
                FragmentTabHost blc = zVar3.blc();
                i = this.this$0.fCg;
                blc.setCurrentTabByType(i);
            } else {
                this.this$0.W(this.this$0.getIntent());
            }
            this.this$0.fCh = false;
            zVar2 = this.this$0.fCk;
            zVar2.bla();
        }
    }
}
