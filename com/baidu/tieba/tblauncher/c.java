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
        ArrayList<com.baidu.tbadk.mainTab.b> qx;
        ao aoVar;
        boolean z;
        ao aoVar2;
        int i;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (qx = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).qx()) != null && qx.size() != 0) {
            aoVar = this.this$0.deK;
            aoVar.L(qx);
            z = this.this$0.isUserChanged;
            if (!z) {
                z2 = this.this$0.deF;
                if (!z2) {
                    this.this$0.W(this.this$0.getIntent());
                    this.this$0.isUserChanged = false;
                    this.this$0.deF = false;
                }
            }
            aoVar2 = this.this$0.deK;
            FragmentTabHost azL = aoVar2.azL();
            i = this.this$0.deE;
            azL.setCurrentTabByType(i);
            this.this$0.isUserChanged = false;
            this.this$0.deF = false;
        }
    }
}
