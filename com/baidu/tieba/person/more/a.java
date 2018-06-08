package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c fPN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<e> abVar) {
        this.mListView = bdTypeListView;
        this.fPN = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fQD);
        this.fPN.b(abVar);
        this.mAdapters.add(this.fPN);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void notifyDataSetChanged() {
        this.fPN.notifyDataSetChanged();
    }
}
