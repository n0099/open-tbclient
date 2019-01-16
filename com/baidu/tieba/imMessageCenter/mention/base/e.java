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
    private BdTypeRecyclerView bRY;
    private ArrayList<h> dqn;
    private b fjN;
    private b fjO;
    private b fjP;
    private b fjQ;
    private b fjR;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bRY = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.fjN = new b(tbPageContext, a.fjv);
        this.fjO = new b(tbPageContext, a.fjw);
        this.fjP = new b(tbPageContext, a.fjz);
        this.fjQ = new b(tbPageContext, a.fjy);
        this.fjR = new b(tbPageContext, a.fjx);
        this.mAdapters.add(this.fjN);
        this.mAdapters.add(this.fjO);
        this.mAdapters.add(this.fjP);
        this.mAdapters.add(this.fjQ);
        this.mAdapters.add(this.fjR);
        this.bRY.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRY.setData(arrayList);
        this.dqn = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bRY.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.fjR.e(adVar);
        this.fjQ.e(adVar);
        this.fjP.e(adVar);
    }
}
