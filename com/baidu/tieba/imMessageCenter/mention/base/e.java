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
    private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
    private ArrayList<m> eYf;
    private b gWW;
    private b gWX;
    private b gWY;
    private b gWZ;
    private b gXa;
    private BdTypeRecyclerView yJ;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.yJ = bdTypeRecyclerView;
            r(tbPageContext);
        }
    }

    private void r(TbPageContext tbPageContext) {
        this.gWW = new b(tbPageContext, a.gWE);
        this.gWX = new b(tbPageContext, a.gWF);
        this.gWY = new b(tbPageContext, a.gWI);
        this.gWZ = new b(tbPageContext, a.gWH);
        this.gXa = new b(tbPageContext, a.gWG);
        this.agy.add(this.gWW);
        this.agy.add(this.gWX);
        this.agy.add(this.gWY);
        this.agy.add(this.gWZ);
        this.agy.add(this.gXa);
        this.yJ.addAdapters(this.agy);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
        }
    }

    public void setData(ArrayList<m> arrayList) {
        this.yJ.setData(arrayList);
        this.eYf = arrayList;
    }

    public void notifyDataSetChanged() {
        this.yJ.getAdapter().notifyDataSetChanged();
    }

    public void e(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void a(ab abVar) {
        this.gXa.a(abVar);
        this.gWZ.a(abVar);
        this.gWY.a(abVar);
    }
}
