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
    private BdTypeRecyclerView Xe;
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private ArrayList<q> igW;
    private b kwA;
    private b kwB;
    private b kwC;
    private b kwD;
    private b kwz;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Xe = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.kwz = new b(tbPageContext, a.kwi);
        this.kwA = new b(tbPageContext, a.kwj);
        this.kwB = new b(tbPageContext, a.kwm);
        this.kwC = new b(tbPageContext, a.kwl);
        this.kwD = new b(tbPageContext, a.kwk);
        this.bky.add(this.kwz);
        this.bky.add(this.kwA);
        this.bky.add(this.kwB);
        this.bky.add(this.kwC);
        this.bky.add(this.kwD);
        this.Xe.addAdapters(this.bky);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Xe.setData(arrayList);
        this.igW = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Xe.getAdapter().notifyDataSetChanged();
    }

    public void DL(int i) {
        if (this.Xe != null) {
            this.Xe.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab abVar) {
        this.kwD.setOnCardSubClickListener(abVar);
        this.kwC.setOnCardSubClickListener(abVar);
        this.kwB.setOnCardSubClickListener(abVar);
    }
}
