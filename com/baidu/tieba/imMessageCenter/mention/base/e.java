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
    private BdTypeRecyclerView NY;
    private ArrayList<m> ePx;
    private b gQP;
    private b gQQ;
    private b gQR;
    private b gQS;
    private b gQT;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.NY = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.gQP = new b(tbPageContext, a.gQy);
        this.gQQ = new b(tbPageContext, a.gQz);
        this.gQR = new b(tbPageContext, a.gQC);
        this.gQS = new b(tbPageContext, a.gQB);
        this.gQT = new b(tbPageContext, a.gQA);
        this.mAdapters.add(this.gQP);
        this.mAdapters.add(this.gQQ);
        this.mAdapters.add(this.gQR);
        this.mAdapters.add(this.gQS);
        this.mAdapters.add(this.gQT);
        this.NY.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.NY.setData(arrayList);
        this.ePx = arrayList;
    }

    public void notifyDataSetChanged() {
        this.NY.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gQT.b(abVar);
        this.gQS.b(abVar);
        this.gQR.b(abVar);
    }
}
