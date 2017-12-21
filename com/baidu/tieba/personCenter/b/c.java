package com.baidu.tieba.personCenter.b;

import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class c {
    a fsK;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.fsK = new a(bdTypeListView, tbPageContext, bdUniqueId);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.b.c.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                c.this.fsK.bae();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        this.mListView.setData(cVar.fsY);
    }

    public void notifyDataSetChanged() {
        this.fsK.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.fsK.onChangeSkinType();
    }

    public void bad() {
        this.fsK.bad();
    }

    public void bae() {
        this.fsK.bae();
    }
}
