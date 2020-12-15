package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private List<com.baidu.adp.widget.ListView.a> jIK = new ArrayList();
    private BdTypeRecyclerView jIL;
    private d lCO;
    private e lCP;
    private f lCQ;
    private g lCR;
    private h lCS;
    private i lCT;
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jIL = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        Nt();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jIK);
    }

    private void Nt() {
        this.lCQ = new f(this.mPageContext, k.inq);
        this.lCP = new e(this.mPageContext, k.inr);
        this.lCO = new d(this.mPageContext, k.f4int);
        this.lCR = new g(this.mPageContext, k.eIX);
        this.lCS = new h(this.mPageContext, k.inv);
        this.lCT = new i(this.mPageContext, l.eJq);
        this.jIK.add(this.lCQ);
        this.jIK.add(this.lCP);
        this.jIK.add(this.lCO);
        this.jIK.add(this.lCR);
        this.jIK.add(this.lCS);
        this.jIK.add(this.lCT);
    }

    private void a(v vVar) {
        this.lCQ.a(vVar);
        this.lCP.a(vVar);
        this.lCO.a(vVar);
        this.lCR.a(vVar);
        this.lCS.a(vVar);
        this.lCT.a(vVar);
    }

    public void cv(List<q> list) {
        this.mDataList = list;
        this.jIL.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jIL != null) {
            this.jIL.getListAdapter().notifyDataSetChanged();
        }
    }
}
