package com.baidu.tieba.person.god;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a eiz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.eiz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        TbPageContext<?> tbPageContext;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016474) {
            List<com.baidu.tieba.a.a> list = (List) customResponsedMessage.getData();
            for (com.baidu.tieba.a.a aVar : list) {
                tbPageContext = this.eiz.bCb;
                aVar.m(tbPageContext);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            bdTypeListView = this.eiz.bou;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.eiz.bou;
                bdTypeListView2.g(arrayList);
            }
        }
    }
}
