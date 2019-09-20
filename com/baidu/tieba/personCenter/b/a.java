package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.tieba.personCenter.data.h;
import com.baidu.tieba.personCenter.data.j;
import com.baidu.tieba.personCenter.data.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private d imG;
    private com.baidu.tieba.personCenter.a.a imH;
    private com.baidu.tieba.personCenter.a.b imI;
    private f imJ;
    private e imK;
    private com.baidu.tieba.personCenter.a.c imq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.imG = new d(tbPageContext, h.inq);
        this.imH = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.imX);
        this.imI = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.imY);
        this.imJ = new f(tbPageContext, m.inC);
        this.imq = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.inp);
        this.imK = new e(tbPageContext, j.inw);
        this.mAdapters.add(this.imG);
        this.mAdapters.add(this.imH);
        this.mAdapters.add(this.imI);
        this.mAdapters.add(this.imJ);
        this.mAdapters.add(this.imq);
        this.mAdapters.add(this.imK);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void cch() {
        this.imH.cch();
    }

    public void cci() {
        this.imH.destroy();
    }
}
