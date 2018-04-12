package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private BdTypeRecyclerView bnQ;
    private ArrayList<h> cGa;
    private b eoY;
    private b eoZ;
    private b epa;
    private b epb;
    private b epc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bnQ = bdTypeRecyclerView;
            o(tbPageContext);
        }
    }

    private void o(TbPageContext tbPageContext) {
        this.eoY = new b(tbPageContext, a.eoF);
        this.eoZ = new b(tbPageContext, a.eoG);
        this.epa = new b(tbPageContext, a.eoJ);
        this.epb = new b(tbPageContext, a.eoI);
        this.epc = new b(tbPageContext, a.eoH);
        this.mAdapters.add(this.eoY);
        this.mAdapters.add(this.eoZ);
        this.mAdapters.add(this.epa);
        this.mAdapters.add(this.epb);
        this.mAdapters.add(this.epc);
        this.bnQ.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bnQ.setData(arrayList);
        this.cGa = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bnQ.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void d(ab abVar) {
        this.epc.d(abVar);
        this.epb.d(abVar);
        this.epa.d(abVar);
    }
}
