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
    private BdTypeRecyclerView bMI;
    private ArrayList<h> deX;
    private b eXX;
    private b eXY;
    private b eXZ;
    private b eYa;
    private b eYb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bMI = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.eXX = new b(tbPageContext, a.eXF);
        this.eXY = new b(tbPageContext, a.eXG);
        this.eXZ = new b(tbPageContext, a.eXJ);
        this.eYa = new b(tbPageContext, a.eXI);
        this.eYb = new b(tbPageContext, a.eXH);
        this.mAdapters.add(this.eXX);
        this.mAdapters.add(this.eXY);
        this.mAdapters.add(this.eXZ);
        this.mAdapters.add(this.eYa);
        this.mAdapters.add(this.eYb);
        this.bMI.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bMI.setData(arrayList);
        this.deX = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bMI.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.eYb.e(adVar);
        this.eYa.e(adVar);
        this.eXZ.e(adVar);
    }
}
