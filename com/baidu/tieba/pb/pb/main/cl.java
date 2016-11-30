package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl extends CustomMessageListener {
    final /* synthetic */ ck ewv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl(ck ckVar, int i) {
        super(i);
        this.ewv = ckVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        PbActivity pbActivity;
        ArrayList arrayList;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
            AbsDelegateAdapterList blI = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).blI();
            Iterator it = blI.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof ct) {
                    pbActivity = this.ewv.eug;
                    ((ct) aVar).aa(pbActivity);
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                        arrayList = this.ewv.ewp;
                        arrayList.add((com.baidu.tieba.pb.pb.a.a) aVar);
                    }
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                        this.ewv.ewk = (com.baidu.tieba.pb.pb.a.b) aVar;
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(blI);
            list = this.ewv.ewt;
            list.clear();
            list2 = this.ewv.ewt;
            list2.addAll(arrayList2);
            bdTypeListView = this.ewv.aML;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.ewv.aML;
                bdTypeListView2.g(arrayList2);
            }
        }
    }
}
