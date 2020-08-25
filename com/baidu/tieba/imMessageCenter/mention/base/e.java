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
/* loaded from: classes16.dex */
public class e {
    private BdTypeRecyclerView Wu;
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private ArrayList<q> hss;
    private b jGA;
    private b jGB;
    private b jGC;
    private b jGy;
    private b jGz;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Wu = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.jGy = new b(tbPageContext, a.jGh);
        this.jGz = new b(tbPageContext, a.jGi);
        this.jGA = new b(tbPageContext, a.jGl);
        this.jGB = new b(tbPageContext, a.jGk);
        this.jGC = new b(tbPageContext, a.jGj);
        this.bbu.add(this.jGy);
        this.bbu.add(this.jGz);
        this.bbu.add(this.jGA);
        this.bbu.add(this.jGB);
        this.bbu.add(this.jGC);
        this.Wu.addAdapters(this.bbu);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Wu.setData(arrayList);
        this.hss = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Wu.getAdapter().notifyDataSetChanged();
    }

    public void BY(int i) {
        if (this.Wu != null) {
            this.Wu.removeItem(i);
        }
    }

    public void e(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.jGC.setOnCardSubClickListener(aaVar);
        this.jGB.setOnCardSubClickListener(aaVar);
        this.jGA.setOnCardSubClickListener(aaVar);
    }
}
