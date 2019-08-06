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
    private BdTypeRecyclerView Op;
    private ArrayList<m> eUE;
    private b gXR;
    private b gXS;
    private b gXT;
    private b gXU;
    private b gXV;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Op = bdTypeRecyclerView;
            r(tbPageContext);
        }
    }

    private void r(TbPageContext tbPageContext) {
        this.gXR = new b(tbPageContext, a.gXA);
        this.gXS = new b(tbPageContext, a.gXB);
        this.gXT = new b(tbPageContext, a.gXE);
        this.gXU = new b(tbPageContext, a.gXD);
        this.gXV = new b(tbPageContext, a.gXC);
        this.mAdapters.add(this.gXR);
        this.mAdapters.add(this.gXS);
        this.mAdapters.add(this.gXT);
        this.mAdapters.add(this.gXU);
        this.mAdapters.add(this.gXV);
        this.Op.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Op.setData(arrayList);
        this.eUE = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Op.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gXV.b(abVar);
        this.gXU.b(abVar);
        this.gXT.b(abVar);
    }
}
