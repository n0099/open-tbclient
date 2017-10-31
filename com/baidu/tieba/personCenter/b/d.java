package com.baidu.tieba.personCenter.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tieba.personCenter.a.c fif;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public d(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.fif = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fiJ);
        this.mAdapters.add(this.fif);
        this.mListView.addAdapters(this.mAdapters);
    }
}
