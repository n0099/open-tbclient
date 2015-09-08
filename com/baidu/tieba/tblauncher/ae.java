package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> qD;
        am amVar;
        boolean z;
        am amVar2;
        int i;
        boolean z2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (qD = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).qD()) != null && qD.size() != 0) {
            amVar = this.this$0.cUv;
            amVar.L(qD);
            z = this.this$0.cUp;
            if (!z) {
                z2 = this.this$0.cUq;
                if (!z2) {
                    this.this$0.X(this.this$0.getIntent());
                    this.this$0.cUp = false;
                    this.this$0.cUq = false;
                }
            }
            amVar2 = this.this$0.cUv;
            FragmentTabHost awj = amVar2.awj();
            i = this.this$0.cUo;
            awj.setCurrentTabByType(i);
            this.this$0.cUp = false;
            this.this$0.cUq = false;
        }
    }
}
