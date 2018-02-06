package com.baidu.tieba.personCenter.b;

import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.d;
/* loaded from: classes.dex */
public class c {
    a gjl;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gjl = new a(bdTypeListView, tbPageContext, bdUniqueId);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.b.c.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                c.this.gjl.biH();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void b(d dVar) {
        this.mListView.setData(dVar.gjB);
    }

    public void notifyDataSetChanged() {
        this.gjl.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gjl.onChangeSkinType();
    }

    public void biG() {
        this.gjl.biG();
    }

    public void biH() {
        this.gjl.biH();
    }
}
