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
    private ArrayList<n> iFV;
    private b kTl;
    private b kTm;
    private b kTn;
    private b kTo;
    private b kTp;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.XW = bdTypeRecyclerView;
            y(tbPageContext);
        }
    }

    private void y(TbPageContext tbPageContext) {
        this.kTl = new b(tbPageContext, a.kSV);
        this.kTm = new b(tbPageContext, a.kSW);
        this.kTn = new b(tbPageContext, a.kSZ);
        this.kTo = new b(tbPageContext, a.kSY);
        this.kTp = new b(tbPageContext, a.kSX);
        this.bns.add(this.kTl);
        this.bns.add(this.kTm);
        this.bns.add(this.kTn);
        this.bns.add(this.kTo);
        this.bns.add(this.kTp);
        this.XW.addAdapters(this.bns);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
        }
    }

    public void setData(ArrayList<n> arrayList) {
        this.XW.setData(arrayList);
        this.iFV = arrayList;
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
        this.kTp.setOnCardSubClickListener(abVar);
        this.kTo.setOnCardSubClickListener(abVar);
        this.kTn.setOnCardSubClickListener(abVar);
    }
}
