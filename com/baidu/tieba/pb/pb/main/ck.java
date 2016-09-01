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
public class ck extends CustomMessageListener {
    final /* synthetic */ cj eoI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(cj cjVar, int i) {
        super(i);
        this.eoI = cjVar;
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
            AbsDelegateAdapterList biC = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).biC();
            Iterator it = biC.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof cs) {
                    pbActivity = this.eoI.emy;
                    ((cs) aVar).ac(pbActivity);
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                        arrayList = this.eoI.eoD;
                        arrayList.add((com.baidu.tieba.pb.pb.a.a) aVar);
                    }
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                        this.eoI.eoy = (com.baidu.tieba.pb.pb.a.b) aVar;
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(biC);
            list = this.eoI.eoG;
            list.clear();
            list2 = this.eoI.eoG;
            list2.addAll(arrayList2);
            bdTypeListView = this.eoI.bBT;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.eoI.bBT;
                bdTypeListView2.g(arrayList2);
            }
        }
    }
}
