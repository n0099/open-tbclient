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
        ArrayList<com.baidu.tbadk.mainTab.b> oj;
        ae aeVar;
        boolean z;
        ae aeVar2;
        ae aeVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (oj = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).oj()) != null && oj.size() != 0) {
            aeVar = this.this$0.fGw;
            aeVar.ai(oj);
            z = this.this$0.fGt;
            if (z) {
                aeVar3 = this.this$0.fGw;
                FragmentTabHost bnZ = aeVar3.bnZ();
                i = this.this$0.fGs;
                bnZ.setCurrentTabByType(i);
            } else {
                this.this$0.z(this.this$0.getIntent());
            }
            this.this$0.fGt = false;
            aeVar2 = this.this$0.fGw;
            aeVar2.bnW();
        }
    }
}
