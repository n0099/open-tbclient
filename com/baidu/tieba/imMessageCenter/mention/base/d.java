package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private BdTypeRecyclerView Yc;
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private ArrayList<n> iES;
    private b kPN;
    private b kPO;
    private b kPP;
    private b kPQ;
    private b kPR;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Yc = bdTypeRecyclerView;
            w(tbPageContext);
        }
    }

    private void w(TbPageContext tbPageContext) {
        this.kPN = new b(tbPageContext, a.kPx);
        this.kPO = new b(tbPageContext, a.kPy);
        this.kPP = new b(tbPageContext, a.kPB);
        this.kPQ = new b(tbPageContext, a.kPA);
        this.kPR = new b(tbPageContext, a.kPz);
        this.boM.add(this.kPN);
        this.boM.add(this.kPO);
        this.boM.add(this.kPP);
        this.boM.add(this.kPQ);
        this.boM.add(this.kPR);
        this.Yc.addAdapters(this.boM);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
        }
    }

    public void setData(ArrayList<n> arrayList) {
        this.Yc.setData(arrayList);
        this.iES = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Yc.getAdapter().notifyDataSetChanged();
    }

    public void EQ(int i) {
        if (this.Yc != null) {
            this.Yc.removeItem(i);
        }
    }

    public void e(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void a(x xVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar != null) {
                aVar.a(xVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.kPR.setOnCardSubClickListener(aaVar);
        this.kPQ.setOnCardSubClickListener(aaVar);
        this.kPP.setOnCardSubClickListener(aaVar);
    }
}
