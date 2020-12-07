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
    private List<com.baidu.adp.widget.ListView.a> jII = new ArrayList();
    private BdTypeRecyclerView jIJ;
    private d lCM;
    private e lCN;
    private f lCO;
    private g lCP;
    private h lCQ;
    private i lCR;
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jIJ = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        Nt();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jII);
    }

    private void Nt() {
        this.lCO = new f(this.mPageContext, k.ino);
        this.lCN = new e(this.mPageContext, k.inp);
        this.lCM = new d(this.mPageContext, k.inq);
        this.lCP = new g(this.mPageContext, k.eIX);
        this.lCQ = new h(this.mPageContext, k.f4int);
        this.lCR = new i(this.mPageContext, l.eJq);
        this.jII.add(this.lCO);
        this.jII.add(this.lCN);
        this.jII.add(this.lCM);
        this.jII.add(this.lCP);
        this.jII.add(this.lCQ);
        this.jII.add(this.lCR);
    }

    private void a(v vVar) {
        this.lCO.a(vVar);
        this.lCN.a(vVar);
        this.lCM.a(vVar);
        this.lCP.a(vVar);
        this.lCQ.a(vVar);
        this.lCR.a(vVar);
    }

    public void cv(List<q> list) {
        this.mDataList = list;
        this.jIJ.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jIJ != null) {
            this.jIJ.getListAdapter().notifyDataSetChanged();
        }
    }
}
