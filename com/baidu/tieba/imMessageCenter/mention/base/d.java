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
    private BdTypeRecyclerView Ya;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private ArrayList<n> iAl;
    private b kLi;
    private b kLj;
    private b kLk;
    private b kLl;
    private b kLm;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Ya = bdTypeRecyclerView;
            w(tbPageContext);
        }
    }

    private void w(TbPageContext tbPageContext) {
        this.kLi = new b(tbPageContext, a.kKS);
        this.kLj = new b(tbPageContext, a.kKT);
        this.kLk = new b(tbPageContext, a.kKW);
        this.kLl = new b(tbPageContext, a.kKV);
        this.kLm = new b(tbPageContext, a.kKU);
        this.bjZ.add(this.kLi);
        this.bjZ.add(this.kLj);
        this.bjZ.add(this.kLk);
        this.bjZ.add(this.kLl);
        this.bjZ.add(this.kLm);
        this.Ya.addAdapters(this.bjZ);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
        }
    }

    public void setData(ArrayList<n> arrayList) {
        this.Ya.setData(arrayList);
        this.iAl = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Ya.getAdapter().notifyDataSetChanged();
    }

    public void Dj(int i) {
        if (this.Ya != null) {
            this.Ya.removeItem(i);
        }
    }

    public void e(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void a(x xVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar != null) {
                aVar.a(xVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.kLm.setOnCardSubClickListener(aaVar);
        this.kLl.setOnCardSubClickListener(aaVar);
        this.kLk.setOnCardSubClickListener(aaVar);
    }
}
