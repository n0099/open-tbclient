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
    private List<com.baidu.adp.widget.ListView.a> jNU = new ArrayList();
    private BdTypeRecyclerView jYR;
    private c lMd;
    private d lMe;
    private e lMf;
    private f lMg;
    private g lMh;
    private h lMi;
    private List<n> mDataList;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jYR = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        Kw();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jNU);
    }

    private void Kw() {
        this.lMf = new e(this.mPageContext, k.iAO);
        this.lMe = new d(this.mPageContext, k.iAP);
        this.lMd = new c(this.mPageContext, k.iAQ);
        this.lMg = new f(this.mPageContext, k.eQr);
        this.lMh = new g(this.mPageContext, k.iAS);
        this.lMi = new h(this.mPageContext, l.eQK);
        this.jNU.add(this.lMf);
        this.jNU.add(this.lMe);
        this.jNU.add(this.lMd);
        this.jNU.add(this.lMg);
        this.jNU.add(this.lMh);
        this.jNU.add(this.lMi);
    }

    private void a(s sVar) {
        this.lMf.a(sVar);
        this.lMe.a(sVar);
        this.lMd.a(sVar);
        this.lMg.a(sVar);
        this.lMh.a(sVar);
        this.lMi.a(sVar);
    }

    public void cx(List<n> list) {
        this.mDataList = list;
        this.jYR.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jYR != null) {
            this.jYR.getListAdapter().notifyDataSetChanged();
        }
    }
}
