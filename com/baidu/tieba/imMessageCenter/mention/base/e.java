package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private BdTypeRecyclerView cdO;
    private ArrayList<i> dnR;
    private b eUe;
    private b eUf;
    private b eUg;
    private b eUh;
    private b eUi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.cdO = bdTypeRecyclerView;
            o(tbPageContext);
        }
    }

    private void o(TbPageContext tbPageContext) {
        this.eUe = new b(tbPageContext, a.eTK);
        this.eUf = new b(tbPageContext, a.eTL);
        this.eUg = new b(tbPageContext, a.eTO);
        this.eUh = new b(tbPageContext, a.eTN);
        this.eUi = new b(tbPageContext, a.eTM);
        this.mAdapters.add(this.eUe);
        this.mAdapters.add(this.eUf);
        this.mAdapters.add(this.eUg);
        this.mAdapters.add(this.eUh);
        this.mAdapters.add(this.eUi);
        this.cdO.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<i> arrayList) {
        this.cdO.setData(arrayList);
        this.dnR = arrayList;
    }

    public void notifyDataSetChanged() {
        this.cdO.getAdapter().notifyDataSetChanged();
    }

    public void d(o oVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(oVar);
            }
        }
    }

    public void c(v vVar) {
        this.eUi.c(vVar);
        this.eUh.c(vVar);
        this.eUg.c(vVar);
    }
}
