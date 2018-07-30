package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c fUc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ad<e> adVar) {
        this.mListView = bdTypeListView;
        this.fUc = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fUS);
        this.fUc.b(adVar);
        this.mAdapters.add(this.fUc);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void notifyDataSetChanged() {
        this.fUc.notifyDataSetChanged();
    }
}
