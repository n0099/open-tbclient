package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.tieba.personCenter.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c hLg;
    private d hLw;
    private com.baidu.tieba.personCenter.a.a hLx;
    private com.baidu.tieba.personCenter.a.b hLy;
    private e hLz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLw = new d(tbPageContext, g.hMc);
        this.hLx = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.hLM);
        this.hLy = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.hLN);
        this.hLz = new e(tbPageContext, i.hMg);
        this.hLg = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.hMb);
        this.mAdapters.add(this.hLw);
        this.mAdapters.add(this.hLx);
        this.mAdapters.add(this.hLy);
        this.mAdapters.add(this.hLz);
        this.mAdapters.add(this.hLg);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bQt() {
        this.hLx.bQt();
    }

    public void bQu() {
        this.hLx.destroy();
    }
}
