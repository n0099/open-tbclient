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
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private ArrayList<q> iaV;
    private b kqD;
    private b kqE;
    private b kqF;
    private b kqG;
    private b kqH;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Xe = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.kqD = new b(tbPageContext, a.kqm);
        this.kqE = new b(tbPageContext, a.kqn);
        this.kqF = new b(tbPageContext, a.kqq);
        this.kqG = new b(tbPageContext, a.kqp);
        this.kqH = new b(tbPageContext, a.kqo);
        this.bje.add(this.kqD);
        this.bje.add(this.kqE);
        this.bje.add(this.kqF);
        this.bje.add(this.kqG);
        this.bje.add(this.kqH);
        this.Xe.addAdapters(this.bje);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Xe.setData(arrayList);
        this.iaV = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Xe.getAdapter().notifyDataSetChanged();
    }

    public void Dy(int i) {
        if (this.Xe != null) {
            this.Xe.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab abVar) {
        this.kqH.setOnCardSubClickListener(abVar);
        this.kqG.setOnCardSubClickListener(abVar);
        this.kqF.setOnCardSubClickListener(abVar);
    }
}
