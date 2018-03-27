package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.v;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c giT;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, v<e> vVar) {
        this.mListView = bdTypeListView;
        this.giT = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.gjL);
        this.giT.b(vVar);
        this.mAdapters.add(this.giT);
        this.mListView.addAdapters(this.mAdapters);
    }
}
