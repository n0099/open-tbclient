package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.ac;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class e {
    private BdTypeRecyclerView Xi;
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private ArrayList<q> ihK;
    private b kxj;
    private b kxk;
    private b kxl;
    private b kxm;
    private b kxn;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Xi = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.kxj = new b(tbPageContext, a.kwS);
        this.kxk = new b(tbPageContext, a.kwT);
        this.kxl = new b(tbPageContext, a.kwW);
        this.kxm = new b(tbPageContext, a.kwV);
        this.kxn = new b(tbPageContext, a.kwU);
        this.biN.add(this.kxj);
        this.biN.add(this.kxk);
        this.biN.add(this.kxl);
        this.biN.add(this.kxm);
        this.biN.add(this.kxn);
        this.Xi.addAdapters(this.biN);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Xi.setData(arrayList);
        this.ihK = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Xi.getAdapter().notifyDataSetChanged();
    }

    public void Ej(int i) {
        if (this.Xi != null) {
            this.Xi.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab abVar) {
        this.kxn.setOnCardSubClickListener(abVar);
        this.kxm.setOnCardSubClickListener(abVar);
        this.kxl.setOnCardSubClickListener(abVar);
    }
}
