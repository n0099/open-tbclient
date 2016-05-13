package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca extends CustomMessageListener {
    final /* synthetic */ bz dkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(bz bzVar, int i) {
        super(i);
        this.dkp = bzVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
            AbsDelegateAdapterList aTv = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).aTv();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aTv);
            list = this.dkp.dkn;
            list.clear();
            list2 = this.dkp.dkn;
            list2.addAll(arrayList);
            bdTypeListView = this.dkp.bej;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.dkp.bej;
                bdTypeListView2.g(arrayList);
            }
        }
    }
}
