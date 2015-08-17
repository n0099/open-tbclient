package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> CB;
        ai aiVar;
        boolean z;
        ai aiVar2;
        int i;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (CB = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).CB()) != null && CB.size() != 0) {
            aiVar = this.this$0.cLT;
            aiVar.aa(CB);
            z = this.this$0.cLN;
            if (!z) {
                z2 = this.this$0.cLO;
                if (!z2) {
                    this.this$0.T(this.this$0.getIntent());
                    this.this$0.cLN = false;
                    this.this$0.cLO = false;
                }
            }
            aiVar2 = this.this$0.cLT;
            FragmentTabHost arW = aiVar2.arW();
            i = this.this$0.cLM;
            arW.setCurrentTabByType(i);
            this.this$0.cLN = false;
            this.this$0.cLO = false;
        }
    }
}
