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
    private BdTypeRecyclerView XW;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private ArrayList<n> iGj;
    private b kTA;
    private b kTB;
    private b kTC;
    private b kTD;
    private b kTz;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.XW = bdTypeRecyclerView;
            y(tbPageContext);
        }
    }

    private void y(TbPageContext tbPageContext) {
        this.kTz = new b(tbPageContext, a.kTj);
        this.kTA = new b(tbPageContext, a.kTk);
        this.kTB = new b(tbPageContext, a.kTn);
        this.kTC = new b(tbPageContext, a.kTm);
        this.kTD = new b(tbPageContext, a.kTl);
        this.bns.add(this.kTz);
        this.bns.add(this.kTA);
        this.bns.add(this.kTB);
        this.bns.add(this.kTC);
        this.bns.add(this.kTD);
        this.XW.addAdapters(this.bns);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
        }
    }

    public void setData(ArrayList<n> arrayList) {
        this.XW.setData(arrayList);
        this.iGj = arrayList;
    }

    public void notifyDataSetChanged() {
        this.XW.getAdapter().notifyDataSetChanged();
    }

    public void DB(int i) {
        if (this.XW != null) {
            this.XW.removeItem(i);
        }
    }

    public void e(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void a(x xVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar != null) {
                aVar.a(xVar);
            }
        }
    }

    public void setOnCardSubClickListener(ab abVar) {
        this.kTD.setOnCardSubClickListener(abVar);
        this.kTC.setOnCardSubClickListener(abVar);
        this.kTB.setOnCardSubClickListener(abVar);
    }
}
