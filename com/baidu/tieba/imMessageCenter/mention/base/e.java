package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private BdTypeRecyclerView cea;
    private ArrayList<i> doe;
    private b eUq;
    private b eUr;
    private b eUs;
    private b eUt;
    private b eUu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.cea = bdTypeRecyclerView;
            o(tbPageContext);
        }
    }

    private void o(TbPageContext tbPageContext) {
        this.eUq = new b(tbPageContext, a.eTW);
        this.eUr = new b(tbPageContext, a.eTX);
        this.eUs = new b(tbPageContext, a.eUa);
        this.eUt = new b(tbPageContext, a.eTZ);
        this.eUu = new b(tbPageContext, a.eTY);
        this.mAdapters.add(this.eUq);
        this.mAdapters.add(this.eUr);
        this.mAdapters.add(this.eUs);
        this.mAdapters.add(this.eUt);
        this.mAdapters.add(this.eUu);
        this.cea.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<i> arrayList) {
        this.cea.setData(arrayList);
        this.doe = arrayList;
    }

    public void notifyDataSetChanged() {
        this.cea.getAdapter().notifyDataSetChanged();
    }

    public void d(o oVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(oVar);
            }
        }
    }

    public void c(v vVar) {
        this.eUu.c(vVar);
        this.eUt.c(vVar);
        this.eUs.c(vVar);
    }
}
