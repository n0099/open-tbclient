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
        ArrayList<com.baidu.tbadk.mainTab.b> nA;
        ab abVar;
        boolean z;
        ab abVar2;
        int i;
        ab abVar3;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (nA = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).nA()) != null && nA.size() != 0) {
            abVar = this.this$0.ewE;
            abVar.U(nA);
            z = this.this$0.isUserChanged;
            if (!z) {
                z2 = this.this$0.ewz;
                if (!z2) {
                    this.this$0.y(this.this$0.getIntent());
                    this.this$0.isUserChanged = false;
                    this.this$0.ewz = false;
                    abVar3 = this.this$0.ewE;
                    abVar3.aVI();
                }
            }
            abVar2 = this.this$0.ewE;
            FragmentTabHost aVL = abVar2.aVL();
            i = this.this$0.ewy;
            aVL.setCurrentTabByType(i);
            this.this$0.isUserChanged = false;
            this.this$0.ewz = false;
            abVar3 = this.this$0.ewE;
            abVar3.aVI();
        }
    }
}
