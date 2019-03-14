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
    private BdTypeRecyclerView Qr;
    private ArrayList<m> eAh;
    private b gzK;
    private b gzL;
    private b gzM;
    private b gzN;
    private b gzO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Qr = bdTypeRecyclerView;
            q(tbPageContext);
        }
    }

    private void q(TbPageContext tbPageContext) {
        this.gzK = new b(tbPageContext, a.gzt);
        this.gzL = new b(tbPageContext, a.gzu);
        this.gzM = new b(tbPageContext, a.gzx);
        this.gzN = new b(tbPageContext, a.gzw);
        this.gzO = new b(tbPageContext, a.gzv);
        this.mAdapters.add(this.gzK);
        this.mAdapters.add(this.gzL);
        this.mAdapters.add(this.gzM);
        this.mAdapters.add(this.gzN);
        this.mAdapters.add(this.gzO);
        this.Qr.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Qr.setData(arrayList);
        this.eAh = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Qr.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gzO.b(abVar);
        this.gzN.b(abVar);
        this.gzM.b(abVar);
    }
}
