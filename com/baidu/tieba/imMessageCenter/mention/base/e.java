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
    private BdTypeRecyclerView bRn;
    private ArrayList<h> dpB;
    private b fiY;
    private b fiZ;
    private b fja;
    private b fjb;
    private b fjc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bRn = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.fiY = new b(tbPageContext, a.fiG);
        this.fiZ = new b(tbPageContext, a.fiH);
        this.fja = new b(tbPageContext, a.fiK);
        this.fjb = new b(tbPageContext, a.fiJ);
        this.fjc = new b(tbPageContext, a.fiI);
        this.mAdapters.add(this.fiY);
        this.mAdapters.add(this.fiZ);
        this.mAdapters.add(this.fja);
        this.mAdapters.add(this.fjb);
        this.mAdapters.add(this.fjc);
        this.bRn.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRn.setData(arrayList);
        this.dpB = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bRn.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void e(ad adVar) {
        this.fjc.e(adVar);
        this.fjb.e(adVar);
        this.fja.e(adVar);
    }
}
