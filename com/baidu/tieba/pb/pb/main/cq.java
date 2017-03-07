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
public class cq extends CustomMessageListener {
    final /* synthetic */ cp emB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(cp cpVar, int i) {
        super(i);
        this.emB = cpVar;
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
            AbsDelegateAdapterList bha = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bha();
            Iterator it = bha.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof cz) {
                    pbActivity = this.emB.eka;
                    ((cz) aVar).aa(pbActivity);
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                        arrayList = this.emB.emw;
                        arrayList.add((com.baidu.tieba.pb.pb.a.a) aVar);
                    }
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                        this.emB.emr = (com.baidu.tieba.pb.pb.a.b) aVar;
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(bha);
            list = this.emB.emz;
            list.clear();
            list2 = this.emB.emz;
            list2.addAll(arrayList2);
            bdTypeListView = this.emB.mListView;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.emB.mListView;
                bdTypeListView2.addAdapters(arrayList2);
            }
        }
    }
}
