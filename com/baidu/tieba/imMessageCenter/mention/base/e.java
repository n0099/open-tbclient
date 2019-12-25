package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private BdTypeRecyclerView Bn;
    private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
    private ArrayList<m> fMN;
    private b hKX;
    private b hKY;
    private b hKZ;
    private b hLa;
    private b hLb;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.Bn = bdTypeRecyclerView;
            s(tbPageContext);
        }
    }

    private void s(TbPageContext tbPageContext) {
        this.hKX = new b(tbPageContext, a.hKG);
        this.hKY = new b(tbPageContext, a.hKH);
        this.hKZ = new b(tbPageContext, a.hKK);
        this.hLa = new b(tbPageContext, a.hKJ);
        this.hLb = new b(tbPageContext, a.hKI);
        this.aoz.add(this.hKX);
        this.aoz.add(this.hKY);
        this.aoz.add(this.hKZ);
        this.aoz.add(this.hLa);
        this.aoz.add(this.hLb);
        this.Bn.addAdapters(this.aoz);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.Bn.setData(arrayList);
        this.fMN = arrayList;
    }

    public void notifyDataSetChanged() {
        this.Bn.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.hLb.setOnCardSubClickListener(zVar);
        this.hLa.setOnCardSubClickListener(zVar);
        this.hKZ.setOnCardSubClickListener(zVar);
    }
}
