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
/* loaded from: classes21.dex */
public class e {
    private BdTypeRecyclerView WM;
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private ArrayList<q> hzD;
    private b jPg;
    private b jPh;
    private b jPi;
    private b jPj;
    private b jPk;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.WM = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.jPg = new b(tbPageContext, a.jOP);
        this.jPh = new b(tbPageContext, a.jOQ);
        this.jPi = new b(tbPageContext, a.jOT);
        this.jPj = new b(tbPageContext, a.jOS);
        this.jPk = new b(tbPageContext, a.jOR);
        this.bdV.add(this.jPg);
        this.bdV.add(this.jPh);
        this.bdV.add(this.jPi);
        this.bdV.add(this.jPj);
        this.bdV.add(this.jPk);
        this.WM.addAdapters(this.bdV);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.WM.setData(arrayList);
        this.hzD = arrayList;
    }

    public void notifyDataSetChanged() {
        this.WM.getAdapter().notifyDataSetChanged();
    }

    public void Cz(int i) {
        if (this.WM != null) {
            this.WM.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.jPk.setOnCardSubClickListener(aaVar);
        this.jPj.setOnCardSubClickListener(aaVar);
        this.jPi.setOnCardSubClickListener(aaVar);
    }
}
