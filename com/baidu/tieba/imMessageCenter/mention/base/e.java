package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private BdTypeRecyclerView Vw;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private ArrayList<o> gMN;
    private b iQT;
    private b iQU;
    private b iQV;
    private b iQW;
    private b iQX;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Vw = bdTypeRecyclerView;
            v(tbPageContext);
        }
    }

    private void v(TbPageContext tbPageContext) {
        this.iQT = new b(tbPageContext, a.iQC);
        this.iQU = new b(tbPageContext, a.iQD);
        this.iQV = new b(tbPageContext, a.iQG);
        this.iQW = new b(tbPageContext, a.iQF);
        this.iQX = new b(tbPageContext, a.iQE);
        this.aSj.add(this.iQT);
        this.aSj.add(this.iQU);
        this.aSj.add(this.iQV);
        this.aSj.add(this.iQW);
        this.aSj.add(this.iQX);
        this.Vw.addAdapters(this.aSj);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
        }
    }

    public void setData(ArrayList<o> arrayList) {
        this.Vw.setData(arrayList);
        this.gMN = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Vw.getAdapter().notifyDataSetChanged();
    }

    public void e(x xVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar != null) {
                aVar.a(xVar);
            }
        }
    }

    public void setOnCardSubClickListener(aa aaVar) {
        this.iQX.setOnCardSubClickListener(aaVar);
        this.iQW.setOnCardSubClickListener(aaVar);
        this.iQV.setOnCardSubClickListener(aaVar);
    }
}
