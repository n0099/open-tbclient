package com.baidu.tieba.pb.pb.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> jOi = new ArrayList();
    private BdTypeRecyclerView jZf;
    private c lMs;
    private d lMt;
    private e lMu;
    private f lMv;
    private g lMw;
    private h lMx;
    private List<n> mDataList;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jZf = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        Kw();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jOi);
    }

    private void Kw() {
        this.lMu = new e(this.mPageContext, k.iBc);
        this.lMt = new d(this.mPageContext, k.iBd);
        this.lMs = new c(this.mPageContext, k.iBe);
        this.lMv = new f(this.mPageContext, k.eQr);
        this.lMw = new g(this.mPageContext, k.iBg);
        this.lMx = new h(this.mPageContext, l.eQK);
        this.jOi.add(this.lMu);
        this.jOi.add(this.lMt);
        this.jOi.add(this.lMs);
        this.jOi.add(this.lMv);
        this.jOi.add(this.lMw);
        this.jOi.add(this.lMx);
    }

    private void a(s sVar) {
        this.lMu.a(sVar);
        this.lMt.a(sVar);
        this.lMs.a(sVar);
        this.lMv.a(sVar);
        this.lMw.a(sVar);
        this.lMx.a(sVar);
    }

    public void cx(List<n> list) {
        this.mDataList = list;
        this.jZf.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jZf != null) {
            this.jZf.getListAdapter().notifyDataSetChanged();
        }
    }
}
