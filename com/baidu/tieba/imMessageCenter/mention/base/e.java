package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private BdTypeRecyclerView byo;
    private ArrayList<h> cQO;
    private b eJa;
    private b eJb;
    private b eJc;
    private b eJd;
    private b eJe;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.byo = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eJa = new b(tbPageContext, a.eIH);
        this.eJb = new b(tbPageContext, a.eII);
        this.eJc = new b(tbPageContext, a.eIL);
        this.eJd = new b(tbPageContext, a.eIK);
        this.eJe = new b(tbPageContext, a.eIJ);
        this.mAdapters.add(this.eJa);
        this.mAdapters.add(this.eJb);
        this.mAdapters.add(this.eJc);
        this.mAdapters.add(this.eJd);
        this.mAdapters.add(this.eJe);
        this.byo.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.byo.setData(arrayList);
        this.cQO = arrayList;
    }

    public void notifyDataSetChanged() {
        this.byo.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.eJe.e(adVar);
        this.eJd.e(adVar);
        this.eJc.e(adVar);
    }
}
