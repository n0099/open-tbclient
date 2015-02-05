package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.g;
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
        ArrayList<b> wt;
        ai aiVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (wt = ((g) customResponsedMessage.getData()).wt()) != null && wt.size() != 0) {
            aiVar = this.this$0.ccJ;
            aiVar.S(wt);
            this.this$0.Y(this.this$0.getIntent());
        }
    }
}
