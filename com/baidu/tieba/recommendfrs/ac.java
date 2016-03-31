package com.baidu.tieba.recommendfrs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(q qVar, int i) {
        super(i);
        this.dVL = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        bdTypeListView = this.dVL.bcd;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.dVL.bcd;
            bdTypeListView2.nj();
            bdTypeListView3 = this.dVL.bcd;
            bdTypeListView3.nk();
        }
    }
}
