package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.ac;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class e {
    private BdTypeRecyclerView Yf;
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private ArrayList<q> isD;
    private b kKC;
    private b kKD;
    private b kKE;
    private b kKF;
    private b kKG;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Yf = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.kKC = new b(tbPageContext, a.kKm);
        this.kKD = new b(tbPageContext, a.kKn);
        this.kKE = new b(tbPageContext, a.kKq);
        this.kKF = new b(tbPageContext, a.kKp);
        this.kKG = new b(tbPageContext, a.kKo);
        this.bnf.add(this.kKC);
        this.bnf.add(this.kKD);
        this.bnf.add(this.kKE);
        this.bnf.add(this.kKF);
        this.bnf.add(this.kKG);
        this.Yf.addAdapters(this.bnf);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Yf.setData(arrayList);
        this.isD = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Yf.getAdapter().notifyDataSetChanged();
    }

    public void EY(int i) {
        if (this.Yf != null) {
            this.Yf.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab abVar) {
        this.kKG.setOnCardSubClickListener(abVar);
        this.kKF.setOnCardSubClickListener(abVar);
        this.kKE.setOnCardSubClickListener(abVar);
    }
}
