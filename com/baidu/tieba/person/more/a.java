package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c gkj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ad<f> adVar) {
        this.mListView = bdTypeListView;
        this.gkj = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gle);
        this.gkj.b(adVar);
        this.mAdapters.add(this.gkj);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void notifyDataSetChanged() {
        this.gkj.notifyDataSetChanged();
    }
}
