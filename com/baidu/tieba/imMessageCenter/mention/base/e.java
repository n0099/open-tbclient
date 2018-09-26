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
    private BdTypeRecyclerView bEd;
    private ArrayList<h> cWF;
    private b eQq;
    private b eQr;
    private b eQs;
    private b eQt;
    private b eQu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bEd = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eQq = new b(tbPageContext, a.ePX);
        this.eQr = new b(tbPageContext, a.ePY);
        this.eQs = new b(tbPageContext, a.eQb);
        this.eQt = new b(tbPageContext, a.eQa);
        this.eQu = new b(tbPageContext, a.ePZ);
        this.mAdapters.add(this.eQq);
        this.mAdapters.add(this.eQr);
        this.mAdapters.add(this.eQs);
        this.mAdapters.add(this.eQt);
        this.mAdapters.add(this.eQu);
        this.bEd.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bEd.setData(arrayList);
        this.cWF = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bEd.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.eQu.e(adVar);
        this.eQt.e(adVar);
        this.eQs.e(adVar);
    }
}
