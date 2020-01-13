package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    private BdTypeRecyclerView Bs;
    private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
    private ArrayList<m> fPW;
    private b hOA;
    private b hOB;
    private b hOC;
    private b hOD;
    private b hOE;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Bs = bdTypeRecyclerView;
            s(tbPageContext);
        }
    }

    private void s(TbPageContext tbPageContext) {
        this.hOA = new b(tbPageContext, a.hOj);
        this.hOB = new b(tbPageContext, a.hOk);
        this.hOC = new b(tbPageContext, a.hOn);
        this.hOD = new b(tbPageContext, a.hOm);
        this.hOE = new b(tbPageContext, a.hOl);
        this.apl.add(this.hOA);
        this.apl.add(this.hOB);
        this.apl.add(this.hOC);
        this.apl.add(this.hOD);
        this.apl.add(this.hOE);
        this.Bs.addAdapters(this.apl);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Bs.setData(arrayList);
        this.fPW = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Bs.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.hOE.setOnCardSubClickListener(zVar);
        this.hOD.setOnCardSubClickListener(zVar);
        this.hOC.setOnCardSubClickListener(zVar);
    }
}
