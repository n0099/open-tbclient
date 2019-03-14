package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c hLg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<f> abVar) {
        this.mListView = bdTypeListView;
        this.hLg = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.hMb);
        this.hLg.d(abVar);
        this.mAdapters.add(this.hLg);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void notifyDataSetChanged() {
        this.hLg.notifyDataSetChanged();
    }
}
