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
    private List<com.baidu.adp.widget.ListView.a> jPR = new ArrayList();
    private BdTypeRecyclerView kbh;
    private c lOu;
    private d lOv;
    private e lOw;
    private f lOx;
    private g lOy;
    private h lOz;
    private List<n> mDataList;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kbh = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        Kz();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jPR);
    }

    private void Kz() {
        this.lOw = new e(this.mPageContext, k.iCL);
        this.lOv = new d(this.mPageContext, k.iCM);
        this.lOu = new c(this.mPageContext, k.iCN);
        this.lOx = new f(this.mPageContext, k.eRS);
        this.lOy = new g(this.mPageContext, k.iCP);
        this.lOz = new h(this.mPageContext, l.eSl);
        this.jPR.add(this.lOw);
        this.jPR.add(this.lOv);
        this.jPR.add(this.lOu);
        this.jPR.add(this.lOx);
        this.jPR.add(this.lOy);
        this.jPR.add(this.lOz);
    }

    private void a(s sVar) {
        this.lOw.a(sVar);
        this.lOv.a(sVar);
        this.lOu.a(sVar);
        this.lOx.a(sVar);
        this.lOy.a(sVar);
        this.lOz.a(sVar);
    }

    public void cx(List<n> list) {
        this.mDataList = list;
        this.kbh.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.kbh != null) {
            this.kbh.getListAdapter().notifyDataSetChanged();
        }
    }
}
