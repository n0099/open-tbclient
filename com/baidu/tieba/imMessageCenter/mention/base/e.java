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
    private BdTypeRecyclerView Qq;
    private ArrayList<m> eAl;
    private b gzL;
    private b gzM;
    private b gzN;
    private b gzO;
    private b gzP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Qq = bdTypeRecyclerView;
            q(tbPageContext);
        }
    }

    private void q(TbPageContext tbPageContext) {
        this.gzL = new b(tbPageContext, a.gzu);
        this.gzM = new b(tbPageContext, a.gzv);
        this.gzN = new b(tbPageContext, a.gzy);
        this.gzO = new b(tbPageContext, a.gzx);
        this.gzP = new b(tbPageContext, a.gzw);
        this.mAdapters.add(this.gzL);
        this.mAdapters.add(this.gzM);
        this.mAdapters.add(this.gzN);
        this.mAdapters.add(this.gzO);
        this.mAdapters.add(this.gzP);
        this.Qq.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Qq.setData(arrayList);
        this.eAl = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Qq.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gzP.b(abVar);
        this.gzO.b(abVar);
        this.gzN.b(abVar);
    }
}
