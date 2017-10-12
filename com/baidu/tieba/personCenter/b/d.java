package com.baidu.tieba.personCenter.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.c.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tieba.personCenter.a.c fad;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fad = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.faF);
        this.mAdapters.add(this.fad);
        this.mListView.addAdapters(this.mAdapters);
    }
}
