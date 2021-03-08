package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private BdTypeRecyclerView Zq;
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private ArrayList<n> iHS;
    private b kVB;
    private b kVC;
    private b kVD;
    private b kVE;
    private b kVF;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Zq = bdTypeRecyclerView;
            y(tbPageContext);
        }
    }

    private void y(TbPageContext tbPageContext) {
        this.kVB = new b(tbPageContext, a.kVl);
        this.kVC = new b(tbPageContext, a.kVm);
        this.kVD = new b(tbPageContext, a.kVp);
        this.kVE = new b(tbPageContext, a.kVo);
        this.kVF = new b(tbPageContext, a.kVn);
        this.boS.add(this.kVB);
        this.boS.add(this.kVC);
        this.boS.add(this.kVD);
        this.boS.add(this.kVE);
        this.boS.add(this.kVF);
        this.Zq.addAdapters(this.boS);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
        }
    }

    public void setData(ArrayList<n> arrayList) {
        this.Zq.setData(arrayList);
        this.iHS = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Zq.getAdapter().notifyDataSetChanged();
    }

    public void DE(int i) {
        if (this.Zq != null) {
            this.Zq.removeItem(i);
        }
    }

    public void e(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void a(x xVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar != null) {
                aVar.a(xVar);
            }
        }
    }

    public void setOnCardSubClickListener(ab abVar) {
        this.kVF.setOnCardSubClickListener(abVar);
        this.kVE.setOnCardSubClickListener(abVar);
        this.kVD.setOnCardSubClickListener(abVar);
    }
}
