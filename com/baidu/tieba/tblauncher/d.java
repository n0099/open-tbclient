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
        ArrayList<com.baidu.tbadk.mainTab.b> nv;
        ab abVar;
        boolean z;
        ab abVar2;
        ab abVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (nv = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).nv()) != null && nv.size() != 0) {
            abVar = this.this$0.fbu;
            abVar.ae(nv);
            z = this.this$0.fbp;
            if (z) {
                abVar3 = this.this$0.fbu;
                FragmentTabHost bed = abVar3.bed();
                i = this.this$0.fbo;
                bed.setCurrentTabByType(i);
            } else {
                this.this$0.B(this.this$0.getIntent());
            }
            this.this$0.fbp = false;
            abVar2 = this.this$0.fbu;
            abVar2.bea();
        }
    }
}
