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
    private ArrayList<m> ePw;
    private b gQK;
    private b gQL;
    private b gQM;
    private b gQN;
    private b gQO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.NZ = bdTypeRecyclerView;
            p(tbPageContext);
        }
    }

    private void p(TbPageContext tbPageContext) {
        this.gQK = new b(tbPageContext, a.gQt);
        this.gQL = new b(tbPageContext, a.gQu);
        this.gQM = new b(tbPageContext, a.gQx);
        this.gQN = new b(tbPageContext, a.gQw);
        this.gQO = new b(tbPageContext, a.gQv);
        this.mAdapters.add(this.gQK);
        this.mAdapters.add(this.gQL);
        this.mAdapters.add(this.gQM);
        this.mAdapters.add(this.gQN);
        this.mAdapters.add(this.gQO);
        this.NZ.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.NZ.setData(arrayList);
        this.ePw = arrayList;
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
        this.gQO.b(abVar);
        this.gQN.b(abVar);
        this.gQM.b(abVar);
    }
}
