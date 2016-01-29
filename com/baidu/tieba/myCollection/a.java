package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ CollectTabActivity cEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CollectTabActivity collectTabActivity, int i) {
        super(i);
        this.cEw = collectTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> qN;
        c cVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016207 && (customResponsedMessage.getData() instanceof com.baidu.tbadk.c.a) && (qN = ((com.baidu.tbadk.c.a) customResponsedMessage.getData()).qN()) != null && !qN.isEmpty()) {
            cVar = this.cEw.cEt;
            cVar.R(qN);
        }
    }
}
