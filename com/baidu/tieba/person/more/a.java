package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c ijo;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<g> abVar) {
        this.mListView = bdTypeListView;
        this.ijo = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ikm);
        this.ijo.d(abVar);
        this.mAdapters.add(this.ijo);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void notifyDataSetChanged() {
        this.ijo.notifyDataSetChanged();
    }
}
