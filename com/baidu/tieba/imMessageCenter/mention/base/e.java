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
    private BdTypeRecyclerView bof;
    private ArrayList<h> cHg;
    private b eqe;
    private b eqf;
    private b eqg;
    private b eqh;
    private b eqi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bof = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eqe = new b(tbPageContext, a.epL);
        this.eqf = new b(tbPageContext, a.epM);
        this.eqg = new b(tbPageContext, a.epP);
        this.eqh = new b(tbPageContext, a.epO);
        this.eqi = new b(tbPageContext, a.epN);
        this.mAdapters.add(this.eqe);
        this.mAdapters.add(this.eqf);
        this.mAdapters.add(this.eqg);
        this.mAdapters.add(this.eqh);
        this.mAdapters.add(this.eqi);
        this.bof.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bof.setData(arrayList);
        this.cHg = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bof.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void d(ab abVar) {
        this.eqi.d(abVar);
        this.eqh.d(abVar);
        this.eqg.d(abVar);
    }
}
