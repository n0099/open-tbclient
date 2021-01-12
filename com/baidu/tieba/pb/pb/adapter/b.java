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
    private List<com.baidu.adp.widget.ListView.a> jRp = new ArrayList();
    private BdTypeRecyclerView jRq;
    private c lDo;
    private d lDp;
    private e lDq;
    private f lDr;
    private g lDs;
    private h lDt;
    private List<n> mDataList;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jRq = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        IY();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jRp);
    }

    private void IY() {
        this.lDq = new e(this.mPageContext, k.ive);
        this.lDp = new d(this.mPageContext, k.ivf);
        this.lDo = new c(this.mPageContext, k.ivg);
        this.lDr = new f(this.mPageContext, k.eOf);
        this.lDs = new g(this.mPageContext, k.ivi);
        this.lDt = new h(this.mPageContext, l.eOy);
        this.jRp.add(this.lDq);
        this.jRp.add(this.lDp);
        this.jRp.add(this.lDo);
        this.jRp.add(this.lDr);
        this.jRp.add(this.lDs);
        this.jRp.add(this.lDt);
    }

    private void a(s sVar) {
        this.lDq.a(sVar);
        this.lDp.a(sVar);
        this.lDo.a(sVar);
        this.lDr.a(sVar);
        this.lDs.a(sVar);
        this.lDt.a(sVar);
    }

    public void cC(List<n> list) {
        this.mDataList = list;
        this.jRq.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jRq != null) {
            this.jRq.getListAdapter().notifyDataSetChanged();
        }
    }
}
