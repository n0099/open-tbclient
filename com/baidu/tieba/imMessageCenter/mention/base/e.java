package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private BdTypeRecyclerView bNt;
    private ArrayList<h> dgc;
    private b eZq;
    private b eZr;
    private b eZs;
    private b eZt;
    private b eZu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bNt = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eZq = new b(tbPageContext, a.eYY);
        this.eZr = new b(tbPageContext, a.eYZ);
        this.eZs = new b(tbPageContext, a.eZc);
        this.eZt = new b(tbPageContext, a.eZb);
        this.eZu = new b(tbPageContext, a.eZa);
        this.mAdapters.add(this.eZq);
        this.mAdapters.add(this.eZr);
        this.mAdapters.add(this.eZs);
        this.mAdapters.add(this.eZt);
        this.mAdapters.add(this.eZu);
        this.bNt.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bNt.setData(arrayList);
        this.dgc = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bNt.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.eZu.e(adVar);
        this.eZt.e(adVar);
        this.eZs.e(adVar);
    }
}
