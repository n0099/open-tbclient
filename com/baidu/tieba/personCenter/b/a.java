package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c ghe;
    private d ghs;
    private com.baidu.tieba.personCenter.a.a ght;
    private com.baidu.tieba.personCenter.a.b ghu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ghs = new d(tbPageContext, f.ghX);
        this.ght = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.ghI);
        this.ghu = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.ghJ);
        this.ghe = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.ghW);
        this.mAdapters.add(this.ghs);
        this.mAdapters.add(this.ght);
        this.mAdapters.add(this.ghu);
        this.mAdapters.add(this.ghe);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bhw() {
        this.ght.bhw();
    }

    public void bhx() {
        this.ght.destroy();
    }
}
