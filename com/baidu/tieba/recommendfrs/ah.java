package com.baidu.tieba.recommendfrs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(r rVar, int i) {
        super(i);
        this.dYM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.dYM.bej;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.dYM.bej;
            bdTypeListView2.k(2000L);
            bdTypeListView3 = this.dYM.bej;
            bdTypeListView3.jy();
        }
    }
}
