package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> og;
        ab abVar;
        boolean z;
        ab abVar2;
        ab abVar3;
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (og = ((com.baidu.tbadk.mainTab.e) customResponsedMessage.getData()).og()) != null && og.size() != 0) {
            abVar = this.this$0.fyW;
            abVar.af(og);
            z = this.this$0.fyT;
            if (z) {
                abVar3 = this.this$0.fyW;
                FragmentTabHost blH = abVar3.blH();
                i = this.this$0.fyS;
                blH.setCurrentTabByType(i);
            } else {
                this.this$0.B(this.this$0.getIntent());
            }
            this.this$0.fyT = false;
            abVar2 = this.this$0.fyW;
            abVar2.blE();
        }
    }
}
