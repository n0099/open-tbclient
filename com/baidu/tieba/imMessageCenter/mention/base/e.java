package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
    private ArrayList<m> eYW;
    private b gXN;
    private b gXO;
    private b gXP;
    private b gXQ;
    private b gXR;
    private BdTypeRecyclerView zj;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.zj = bdTypeRecyclerView;
            r(tbPageContext);
        }
    }

    private void r(TbPageContext tbPageContext) {
        this.gXN = new b(tbPageContext, a.gXv);
        this.gXO = new b(tbPageContext, a.gXw);
        this.gXP = new b(tbPageContext, a.gXz);
        this.gXQ = new b(tbPageContext, a.gXy);
        this.gXR = new b(tbPageContext, a.gXx);
        this.agQ.add(this.gXN);
        this.agQ.add(this.gXO);
        this.agQ.add(this.gXP);
        this.agQ.add(this.gXQ);
        this.agQ.add(this.gXR);
        this.zj.addAdapters(this.agQ);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.zj.setData(arrayList);
        this.eYW = arrayList;
    }

    public void notifyDataSetChanged() {
        this.zj.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void a(ab abVar) {
        this.gXR.a(abVar);
        this.gXQ.a(abVar);
        this.gXP.a(abVar);
    }
}
