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
    private ArrayList<o> gMY;
    private b iRG;
    private b iRH;
    private b iRI;
    private b iRJ;
    private b iRK;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Vw = bdTypeRecyclerView;
            v(tbPageContext);
        }
    }

    private void v(TbPageContext tbPageContext) {
        this.iRG = new b(tbPageContext, a.iRp);
        this.iRH = new b(tbPageContext, a.iRq);
        this.iRI = new b(tbPageContext, a.iRt);
        this.iRJ = new b(tbPageContext, a.iRs);
        this.iRK = new b(tbPageContext, a.iRr);
        this.aSj.add(this.iRG);
        this.aSj.add(this.iRH);
        this.aSj.add(this.iRI);
        this.aSj.add(this.iRJ);
        this.aSj.add(this.iRK);
        this.Vw.addAdapters(this.aSj);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
        }
    }

    public void setData(ArrayList<o> arrayList) {
        this.Vw.setData(arrayList);
        this.gMY = arrayList;
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
        this.iRK.setOnCardSubClickListener(aaVar);
        this.iRJ.setOnCardSubClickListener(aaVar);
        this.iRI.setOnCardSubClickListener(aaVar);
    }
}
