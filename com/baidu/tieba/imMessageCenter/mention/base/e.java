package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.ac;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class e {
    private BdTypeRecyclerView Xc;
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private ArrayList<q> hOy;
    private b kee;
    private b kef;
    private b keg;
    private b keh;
    private b kei;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Xc = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.kee = new b(tbPageContext, a.kdN);
        this.kef = new b(tbPageContext, a.kdO);
        this.keg = new b(tbPageContext, a.kdR);
        this.keh = new b(tbPageContext, a.kdQ);
        this.kei = new b(tbPageContext, a.kdP);
        this.bhH.add(this.kee);
        this.bhH.add(this.kef);
        this.bhH.add(this.keg);
        this.bhH.add(this.keh);
        this.bhH.add(this.kei);
        this.Xc.addAdapters(this.bhH);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Xc.setData(arrayList);
        this.hOy = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Xc.getAdapter().notifyDataSetChanged();
    }

    public void Df(int i) {
        if (this.Xc != null) {
            this.Xc.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.kei.setOnCardSubClickListener(aaVar);
        this.keh.setOnCardSubClickListener(aaVar);
        this.keg.setOnCardSubClickListener(aaVar);
    }
}
