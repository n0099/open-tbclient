package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private BdTypeRecyclerView Oo;
    private ArrayList<m> eWk;
    private b gZL;
    private b gZM;
    private b gZN;
    private b gZO;
    private b gZP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Oo = bdTypeRecyclerView;
            r(tbPageContext);
        }
    }

    private void r(TbPageContext tbPageContext) {
        this.gZL = new b(tbPageContext, a.gZu);
        this.gZM = new b(tbPageContext, a.gZv);
        this.gZN = new b(tbPageContext, a.gZy);
        this.gZO = new b(tbPageContext, a.gZx);
        this.gZP = new b(tbPageContext, a.gZw);
        this.mAdapters.add(this.gZL);
        this.mAdapters.add(this.gZM);
        this.mAdapters.add(this.gZN);
        this.mAdapters.add(this.gZO);
        this.mAdapters.add(this.gZP);
        this.Oo.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Oo.setData(arrayList);
        this.eWk = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Oo.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gZP.b(abVar);
        this.gZO.b(abVar);
        this.gZN.b(abVar);
    }
}
