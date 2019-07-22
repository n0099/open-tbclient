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
    private BdTypeRecyclerView Op;
    private ArrayList<m> eUx;
    private b gWZ;
    private b gXa;
    private b gXb;
    private b gXc;
    private b gXd;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Op = bdTypeRecyclerView;
            r(tbPageContext);
        }
    }

    private void r(TbPageContext tbPageContext) {
        this.gWZ = new b(tbPageContext, a.gWI);
        this.gXa = new b(tbPageContext, a.gWJ);
        this.gXb = new b(tbPageContext, a.gWM);
        this.gXc = new b(tbPageContext, a.gWL);
        this.gXd = new b(tbPageContext, a.gWK);
        this.mAdapters.add(this.gWZ);
        this.mAdapters.add(this.gXa);
        this.mAdapters.add(this.gXb);
        this.mAdapters.add(this.gXc);
        this.mAdapters.add(this.gXd);
        this.Op.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Op.setData(arrayList);
        this.eUx = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Op.getAdapter().notifyDataSetChanged();
    }

    public void d(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(sVar);
            }
        }
    }

    public void b(ab abVar) {
        this.gXd.b(abVar);
        this.gXc.b(abVar);
        this.gXb.b(abVar);
    }
}
