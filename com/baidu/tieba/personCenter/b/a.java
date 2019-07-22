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
    private d ijE;
    private com.baidu.tieba.personCenter.a.a ijF;
    private com.baidu.tieba.personCenter.a.b ijG;
    private f ijH;
    private e ijI;
    private com.baidu.tieba.personCenter.a.c ijo;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ijE = new d(tbPageContext, h.ikn);
        this.ijF = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.ijV);
        this.ijG = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.ijW);
        this.ijH = new f(tbPageContext, m.ikx);
        this.ijo = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ikm);
        this.ijI = new e(tbPageContext, j.ikr);
        this.mAdapters.add(this.ijE);
        this.mAdapters.add(this.ijF);
        this.mAdapters.add(this.ijG);
        this.mAdapters.add(this.ijH);
        this.mAdapters.add(this.ijo);
        this.mAdapters.add(this.ijI);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void cbb() {
        this.ijF.cbb();
    }

    public void cbc() {
        this.ijF.destroy();
    }
}
