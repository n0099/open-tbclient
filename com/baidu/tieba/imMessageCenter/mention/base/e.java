package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private BdTypeRecyclerView Vf;
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private ArrayList<m> gxX;
    private b iCd;
    private b iCe;
    private b iCf;
    private b iCg;
    private b iCh;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Vf = bdTypeRecyclerView;
            v(tbPageContext);
        }
    }

    private void v(TbPageContext tbPageContext) {
        this.iCd = new b(tbPageContext, a.iBM);
        this.iCe = new b(tbPageContext, a.iBN);
        this.iCf = new b(tbPageContext, a.iBQ);
        this.iCg = new b(tbPageContext, a.iBP);
        this.iCh = new b(tbPageContext, a.iBO);
        this.aMd.add(this.iCd);
        this.aMd.add(this.iCe);
        this.aMd.add(this.iCf);
        this.aMd.add(this.iCg);
        this.aMd.add(this.iCh);
        this.Vf.addAdapters(this.aMd);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Vf.setData(arrayList);
        this.gxX = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Vf.getAdapter().notifyDataSetChanged();
    }

    public void e(v vVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar != null) {
                aVar.a(vVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.iCh.setOnCardSubClickListener(zVar);
        this.iCg.setOnCardSubClickListener(zVar);
        this.iCf.setOnCardSubClickListener(zVar);
    }
}
