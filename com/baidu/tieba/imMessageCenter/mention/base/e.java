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
    private BdTypeRecyclerView bym;
    private ArrayList<h> cQR;
    private b eJf;
    private b eJg;
    private b eJh;
    private b eJi;
    private b eJj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bym = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eJf = new b(tbPageContext, a.eIM);
        this.eJg = new b(tbPageContext, a.eIN);
        this.eJh = new b(tbPageContext, a.eIQ);
        this.eJi = new b(tbPageContext, a.eIP);
        this.eJj = new b(tbPageContext, a.eIO);
        this.mAdapters.add(this.eJf);
        this.mAdapters.add(this.eJg);
        this.mAdapters.add(this.eJh);
        this.mAdapters.add(this.eJi);
        this.mAdapters.add(this.eJj);
        this.bym.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bym.setData(arrayList);
        this.cQR = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bym.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.eJj.e(adVar);
        this.eJi.e(adVar);
        this.eJh.e(adVar);
    }
}
