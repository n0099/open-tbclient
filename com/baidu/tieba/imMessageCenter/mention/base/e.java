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
    private BdTypeRecyclerView Vi;
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private ArrayList<m> gyd;
    private b iCj;
    private b iCk;
    private b iCl;
    private b iCm;
    private b iCn;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Vi = bdTypeRecyclerView;
            v(tbPageContext);
        }
    }

    private void v(TbPageContext tbPageContext) {
        this.iCj = new b(tbPageContext, a.iBS);
        this.iCk = new b(tbPageContext, a.iBT);
        this.iCl = new b(tbPageContext, a.iBW);
        this.iCm = new b(tbPageContext, a.iBV);
        this.iCn = new b(tbPageContext, a.iBU);
        this.aMj.add(this.iCj);
        this.aMj.add(this.iCk);
        this.aMj.add(this.iCl);
        this.aMj.add(this.iCm);
        this.aMj.add(this.iCn);
        this.Vi.addAdapters(this.aMj);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Vi.setData(arrayList);
        this.gyd = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Vi.getAdapter().notifyDataSetChanged();
    }

    public void e(v vVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar != null) {
                aVar.a(vVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.iCn.setOnCardSubClickListener(zVar);
        this.iCm.setOnCardSubClickListener(zVar);
        this.iCl.setOnCardSubClickListener(zVar);
    }
}
