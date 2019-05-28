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
    private BdTypeRecyclerView NZ;
    private ArrayList<m> ePx;
    private b gQN;
    private b gQO;
    private b gQP;
    private b gQQ;
    private b gQR;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.NZ = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.gQN = new b(tbPageContext, a.gQw);
        this.gQO = new b(tbPageContext, a.gQx);
        this.gQP = new b(tbPageContext, a.gQA);
        this.gQQ = new b(tbPageContext, a.gQz);
        this.gQR = new b(tbPageContext, a.gQy);
        this.mAdapters.add(this.gQN);
        this.mAdapters.add(this.gQO);
        this.mAdapters.add(this.gQP);
        this.mAdapters.add(this.gQQ);
        this.mAdapters.add(this.gQR);
        this.NZ.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.NZ.setData(arrayList);
        this.ePx = arrayList;
    }

    public void notifyDataSetChanged() {
        this.NZ.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gQR.b(abVar);
        this.gQQ.b(abVar);
        this.gQP.b(abVar);
    }
}
