package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.v;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c giD;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, v<e> vVar) {
        this.mListView = bdTypeListView;
        this.giD = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.gjv);
        this.giD.b(vVar);
        this.mAdapters.add(this.giD);
        this.mListView.addAdapters(this.mAdapters);
    }
}
