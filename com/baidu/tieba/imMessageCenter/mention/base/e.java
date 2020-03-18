package com.baidu.tieba.imMessageCenter.mention.base;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private BdTypeRecyclerView BK;
    private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
    private ArrayList<m> fTp;
    private b hSm;
    private b hSn;
    private b hSo;
    private b hSp;
    private b hSq;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.BK = bdTypeRecyclerView;
            t(tbPageContext);
        }
    }

    private void t(TbPageContext tbPageContext) {
        this.hSm = new b(tbPageContext, a.hRV);
        this.hSn = new b(tbPageContext, a.hRW);
        this.hSo = new b(tbPageContext, a.hRZ);
        this.hSp = new b(tbPageContext, a.hRY);
        this.hSq = new b(tbPageContext, a.hRX);
        this.asP.add(this.hSm);
        this.asP.add(this.hSn);
        this.asP.add(this.hSo);
        this.asP.add(this.hSp);
        this.asP.add(this.hSq);
        this.BK.addAdapters(this.asP);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.BK.setData(arrayList);
        this.fTp = arrayList;
    }

    public void notifyDataSetChanged() {
        this.BK.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.hSq.setOnCardSubClickListener(zVar);
        this.hSp.setOnCardSubClickListener(zVar);
        this.hSo.setOnCardSubClickListener(zVar);
    }
}
