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
public class dd extends CustomMessageListener {
    final /* synthetic */ dc exj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd(dc dcVar, int i) {
        super(i);
        this.exj = dcVar;
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
            AbsDelegateAdapterList blU = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).blU();
            Iterator it = blU.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof du) {
                    pbActivity = this.exj.euf;
                    ((du) aVar).am(pbActivity);
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                        arrayList = this.exj.ewZ;
                        arrayList.add((com.baidu.tieba.pb.pb.a.a) aVar);
                    }
                    if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                        this.exj.ewU = (com.baidu.tieba.pb.pb.a.b) aVar;
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(blU);
            list = this.exj.exg;
            list.clear();
            list2 = this.exj.exg;
            list2.addAll(arrayList2);
            bdTypeListView = this.exj.mListView;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.exj.mListView;
                bdTypeListView2.addAdapters(arrayList2);
            }
        }
    }
}
