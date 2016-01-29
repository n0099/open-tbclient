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
        ArrayList<com.baidu.tbadk.mainTab.b> qN;
        y yVar;
        boolean z;
        y yVar2;
        int i;
        y yVar3;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (qN = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).qN()) != null && qN.size() != 0) {
            yVar = this.this$0.eaD;
            yVar.R(qN);
            z = this.this$0.isUserChanged;
            if (!z) {
                z2 = this.this$0.eay;
                if (!z2) {
                    this.this$0.Y(this.this$0.getIntent());
                    this.this$0.isUserChanged = false;
                    this.this$0.eay = false;
                    yVar3 = this.this$0.eaD;
                    yVar3.aOl();
                }
            }
            yVar2 = this.this$0.eaD;
            FragmentTabHost aOn = yVar2.aOn();
            i = this.this$0.eax;
            aOn.setCurrentTabByType(i);
            this.this$0.isUserChanged = false;
            this.this$0.eay = false;
            yVar3 = this.this$0.eaD;
            yVar3.aOl();
        }
    }
}
