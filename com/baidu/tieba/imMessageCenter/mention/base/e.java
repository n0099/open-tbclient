package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private BdTypeRecyclerView BK;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private ArrayList<m> fSt;
    private b hQA;
    private b hQB;
    private b hQC;
    private b hQD;
    private b hQE;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.BK = bdTypeRecyclerView;
            s(tbPageContext);
        }
    }

    private void s(TbPageContext tbPageContext) {
        this.hQA = new b(tbPageContext, a.hQj);
        this.hQB = new b(tbPageContext, a.hQk);
        this.hQC = new b(tbPageContext, a.hQn);
        this.hQD = new b(tbPageContext, a.hQm);
        this.hQE = new b(tbPageContext, a.hQl);
        this.asE.add(this.hQA);
        this.asE.add(this.hQB);
        this.asE.add(this.hQC);
        this.asE.add(this.hQD);
        this.asE.add(this.hQE);
        this.BK.addAdapters(this.asE);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.BK.setData(arrayList);
        this.fSt = arrayList;
    }

    public void notifyDataSetChanged() {
        this.BK.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.hQE.setOnCardSubClickListener(zVar);
        this.hQD.setOnCardSubClickListener(zVar);
        this.hQC.setOnCardSubClickListener(zVar);
    }
}
