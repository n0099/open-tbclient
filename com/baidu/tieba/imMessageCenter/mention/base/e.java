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
    private ArrayList<m> ezS;
    private b gzA;
    private b gzB;
    private b gzx;
    private b gzy;
    private b gzz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Qr = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.gzx = new b(tbPageContext, a.gzg);
        this.gzy = new b(tbPageContext, a.gzh);
        this.gzz = new b(tbPageContext, a.gzk);
        this.gzA = new b(tbPageContext, a.gzj);
        this.gzB = new b(tbPageContext, a.gzi);
        this.mAdapters.add(this.gzx);
        this.mAdapters.add(this.gzy);
        this.mAdapters.add(this.gzz);
        this.mAdapters.add(this.gzA);
        this.mAdapters.add(this.gzB);
        this.Qr.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Qr.setData(arrayList);
        this.ezS = arrayList;
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
        this.gzB.b(abVar);
        this.gzA.b(abVar);
        this.gzz.b(abVar);
    }
}
