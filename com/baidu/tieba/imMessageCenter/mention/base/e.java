package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private BdTypeRecyclerView Wa;
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private ArrayList<q> gZU;
    private b jiS;
    private b jiT;
    private b jiU;
    private b jiV;
    private b jiW;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Wa = bdTypeRecyclerView;
            y(tbPageContext);
        }
    }

    private void y(TbPageContext tbPageContext) {
        this.jiS = new b(tbPageContext, a.jiB);
        this.jiT = new b(tbPageContext, a.jiC);
        this.jiU = new b(tbPageContext, a.jiF);
        this.jiV = new b(tbPageContext, a.jiE);
        this.jiW = new b(tbPageContext, a.jiD);
        this.aUP.add(this.jiS);
        this.aUP.add(this.jiT);
        this.aUP.add(this.jiU);
        this.aUP.add(this.jiV);
        this.aUP.add(this.jiW);
        this.Wa.addAdapters(this.aUP);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
        }
    }

    public void setData(ArrayList<q> arrayList) {
        this.Wa.setData(arrayList);
        this.gZU = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Wa.getAdapter().notifyDataSetChanged();
    }

    public void zg(int i) {
        if (this.Wa != null) {
            this.Wa.removeItem(i);
        }
    }

    public void e(z zVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar != null) {
                aVar.a(zVar);
            }
        }
    }

    public void a(aa aaVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar != null) {
                aVar.a(aaVar);
            }
        }
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa aaVar) {
        this.jiW.setOnCardSubClickListener(aaVar);
        this.jiV.setOnCardSubClickListener(aaVar);
        this.jiU.setOnCardSubClickListener(aaVar);
    }
}
