package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c icS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<g> abVar) {
        this.mListView = bdTypeListView;
        this.icS = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.idS);
        this.icS.d(abVar);
        this.mAdapters.add(this.icS);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void notifyDataSetChanged() {
        this.icS.notifyDataSetChanged();
    }
}
