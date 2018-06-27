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
    private BdTypeRecyclerView bxH;
    private ArrayList<h> cOi;
    private b eFl;
    private b eFm;
    private b eFn;
    private b eFo;
    private b eFp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bxH = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eFl = new b(tbPageContext, a.eES);
        this.eFm = new b(tbPageContext, a.eET);
        this.eFn = new b(tbPageContext, a.eEW);
        this.eFo = new b(tbPageContext, a.eEV);
        this.eFp = new b(tbPageContext, a.eEU);
        this.mAdapters.add(this.eFl);
        this.mAdapters.add(this.eFm);
        this.mAdapters.add(this.eFn);
        this.mAdapters.add(this.eFo);
        this.mAdapters.add(this.eFp);
        this.bxH.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bxH.setData(arrayList);
        this.cOi = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bxH.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.eFp.e(adVar);
        this.eFo.e(adVar);
        this.eFn.e(adVar);
    }
}
