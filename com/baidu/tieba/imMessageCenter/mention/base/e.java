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
    private BdTypeRecyclerView bwl;
    private ArrayList<h> cQn;
    private b eBv;
    private b eBw;
    private b eBx;
    private b eBy;
    private b eBz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bwl = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eBv = new b(tbPageContext, a.eBc);
        this.eBw = new b(tbPageContext, a.eBd);
        this.eBx = new b(tbPageContext, a.eBg);
        this.eBy = new b(tbPageContext, a.eBf);
        this.eBz = new b(tbPageContext, a.eBe);
        this.mAdapters.add(this.eBv);
        this.mAdapters.add(this.eBw);
        this.mAdapters.add(this.eBx);
        this.mAdapters.add(this.eBy);
        this.mAdapters.add(this.eBz);
        this.bwl.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bwl.setData(arrayList);
        this.cQn = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bwl.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ab abVar) {
        this.eBz.e(abVar);
        this.eBy.e(abVar);
        this.eBx.e(abVar);
    }
}
