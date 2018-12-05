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
    private BdTypeRecyclerView bRk;
    private ArrayList<h> dmJ;
    private b fgf;
    private b fgg;
    private b fgh;
    private b fgi;
    private b fgj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bRk = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.fgf = new b(tbPageContext, a.ffN);
        this.fgg = new b(tbPageContext, a.ffO);
        this.fgh = new b(tbPageContext, a.ffR);
        this.fgi = new b(tbPageContext, a.ffQ);
        this.fgj = new b(tbPageContext, a.ffP);
        this.mAdapters.add(this.fgf);
        this.mAdapters.add(this.fgg);
        this.mAdapters.add(this.fgh);
        this.mAdapters.add(this.fgi);
        this.mAdapters.add(this.fgj);
        this.bRk.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRk.setData(arrayList);
        this.dmJ = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bRk.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.fgj.e(adVar);
        this.fgi.e(adVar);
        this.fgh.e(adVar);
    }
}
