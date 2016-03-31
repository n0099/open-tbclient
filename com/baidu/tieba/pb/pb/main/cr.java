package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr extends CustomMessageListener {
    final /* synthetic */ cq dig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(cq cqVar, int i) {
        super(i);
        this.dig = cqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
            AbsDelegateAdapterList aSO = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).aSO();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aSO);
            list = this.dig.die;
            list.clear();
            list2 = this.dig.die;
            list2.addAll(arrayList);
            bdTypeListView = this.dig.bcd;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.dig.bcd;
                bdTypeListView2.g(arrayList);
            }
        }
    }
}
