package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class e {
    private BdTypeRecyclerView VT;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private ArrayList<q> hfz;
    private b jrA;
    private b jrB;
    private b jrC;
    private b jry;
    private b jrz;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.VT = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.jry = new b(tbPageContext, a.jrh);
        this.jrz = new b(tbPageContext, a.jri);
        this.jrA = new b(tbPageContext, a.jrl);
        this.jrB = new b(tbPageContext, a.jrk);
        this.jrC = new b(tbPageContext, a.jrj);
        this.aWf.add(this.jry);
        this.aWf.add(this.jrz);
        this.aWf.add(this.jrA);
        this.aWf.add(this.jrB);
        this.aWf.add(this.jrC);
        this.VT.addAdapters(this.aWf);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.VT.setData(arrayList);
        this.hfz = arrayList;
    }

    public void notifyDataSetChanged() {
        this.VT.getAdapter().notifyDataSetChanged();
    }

    public void zF(int i) {
        if (this.VT != null) {
            this.VT.removeItem(i);
        }
    }

    public void e(z zVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar != null) {
                aVar.a(zVar);
            }
        }
    }

    public void a(aa aaVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar != null) {
                aVar.a(aaVar);
            }
        }
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa aaVar) {
        this.jrC.setOnCardSubClickListener(aaVar);
        this.jrB.setOnCardSubClickListener(aaVar);
        this.jrA.setOnCardSubClickListener(aaVar);
    }
}
