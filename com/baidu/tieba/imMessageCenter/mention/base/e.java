package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private BdTypeRecyclerView bnQ;
    private ArrayList<h> cFX;
    private b eoV;
    private b eoW;
    private b eoX;
    private b eoY;
    private b eoZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.bnQ = bdTypeRecyclerView;
            o(tbPageContext);
        }
    }

    private void o(TbPageContext tbPageContext) {
        this.eoV = new b(tbPageContext, a.eoC);
        this.eoW = new b(tbPageContext, a.eoD);
        this.eoX = new b(tbPageContext, a.eoG);
        this.eoY = new b(tbPageContext, a.eoF);
        this.eoZ = new b(tbPageContext, a.eoE);
        this.mAdapters.add(this.eoV);
        this.mAdapters.add(this.eoW);
        this.mAdapters.add(this.eoX);
        this.mAdapters.add(this.eoY);
        this.mAdapters.add(this.eoZ);
        this.bnQ.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
        }
    }

    public void setData(ArrayList<h> arrayList) {
        this.bnQ.setData(arrayList);
        this.cFX = arrayList;
    }

    public void notifyDataSetChanged() {
        this.bnQ.getAdapter().notifyDataSetChanged();
    }

    public void d(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void d(ab abVar) {
        this.eoZ.d(abVar);
        this.eoY.d(abVar);
        this.eoX.d(abVar);
    }
}
