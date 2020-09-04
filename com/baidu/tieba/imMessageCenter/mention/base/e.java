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
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private ArrayList<q> hsy;
    private b jGE;
    private b jGF;
    private b jGG;
    private b jGH;
    private b jGI;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Wu = bdTypeRecyclerView;
            x(tbPageContext);
        }
    }

    private void x(TbPageContext tbPageContext) {
        this.jGE = new b(tbPageContext, a.jGn);
        this.jGF = new b(tbPageContext, a.jGo);
        this.jGG = new b(tbPageContext, a.jGr);
        this.jGH = new b(tbPageContext, a.jGq);
        this.jGI = new b(tbPageContext, a.jGp);
        this.bbw.add(this.jGE);
        this.bbw.add(this.jGF);
        this.bbw.add(this.jGG);
        this.bbw.add(this.jGH);
        this.bbw.add(this.jGI);
        this.Wu.addAdapters(this.bbw);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Wu.setData(arrayList);
        this.hsy = arrayList;
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
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void a(ac acVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar != null) {
                aVar.a(acVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.jGI.setOnCardSubClickListener(aaVar);
        this.jGH.setOnCardSubClickListener(aaVar);
        this.jGG.setOnCardSubClickListener(aaVar);
    }
}
