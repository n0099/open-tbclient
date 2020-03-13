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
    private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
    private ArrayList<m> fSG;
    private b hQM;
    private b hQN;
    private b hQO;
    private b hQP;
    private b hQQ;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.BK = bdTypeRecyclerView;
            s(tbPageContext);
        }
    }

    private void s(TbPageContext tbPageContext) {
        this.hQM = new b(tbPageContext, a.hQv);
        this.hQN = new b(tbPageContext, a.hQw);
        this.hQO = new b(tbPageContext, a.hQz);
        this.hQP = new b(tbPageContext, a.hQy);
        this.hQQ = new b(tbPageContext, a.hQx);
        this.asF.add(this.hQM);
        this.asF.add(this.hQN);
        this.asF.add(this.hQO);
        this.asF.add(this.hQP);
        this.asF.add(this.hQQ);
        this.BK.addAdapters(this.asF);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.BK.setData(arrayList);
        this.fSG = arrayList;
    }

    public void notifyDataSetChanged() {
        this.BK.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void setOnCardSubClickListener(z zVar) {
        this.hQQ.setOnCardSubClickListener(zVar);
        this.hQP.setOnCardSubClickListener(zVar);
        this.hQO.setOnCardSubClickListener(zVar);
    }
}
