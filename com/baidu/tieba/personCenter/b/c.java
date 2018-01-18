package com.baidu.tieba.personCenter.b;

import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.d;
/* loaded from: classes.dex */
public class c {
    a ghg;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.ghg = new a(bdTypeListView, tbPageContext, bdUniqueId);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.b.c.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                c.this.ghg.bhw();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public void b(d dVar) {
        this.mListView.setData(dVar.ghw);
    }

    public void notifyDataSetChanged() {
        this.ghg.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.ghg.onChangeSkinType();
    }

    public void bhv() {
        this.ghg.bhv();
    }

    public void bhw() {
        this.ghg.bhw();
    }
}
