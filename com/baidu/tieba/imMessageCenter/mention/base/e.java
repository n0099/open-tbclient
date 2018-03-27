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
    private BdTypeRecyclerView cdR;
    private ArrayList<i> dnU;
    private b eUs;
    private b eUt;
    private b eUu;
    private b eUv;
    private b eUw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.cdR = bdTypeRecyclerView;
            o(tbPageContext);
        }
    }

    private void o(TbPageContext tbPageContext) {
        this.eUs = new b(tbPageContext, a.eTZ);
        this.eUt = new b(tbPageContext, a.eUa);
        this.eUu = new b(tbPageContext, a.eUd);
        this.eUv = new b(tbPageContext, a.eUc);
        this.eUw = new b(tbPageContext, a.eUb);
        this.mAdapters.add(this.eUs);
        this.mAdapters.add(this.eUt);
        this.mAdapters.add(this.eUu);
        this.mAdapters.add(this.eUv);
        this.mAdapters.add(this.eUw);
        this.cdR.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<i> arrayList) {
        this.cdR.setData(arrayList);
        this.dnU = arrayList;
    }

    public void notifyDataSetChanged() {
        this.cdR.getAdapter().notifyDataSetChanged();
    }

    public void d(o oVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(oVar);
            }
        }
    }

    public void c(v vVar) {
        this.eUw.c(vVar);
        this.eUv.c(vVar);
        this.eUu.c(vVar);
    }
}
