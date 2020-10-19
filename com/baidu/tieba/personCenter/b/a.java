package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.a.g;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.personCenter.c.k;
import com.baidu.tieba.personCenter.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeListView fSo;
    private e lCO;
    private com.baidu.tieba.personCenter.a.a lCP;
    private com.baidu.tieba.personCenter.a.b lCQ;
    private g lCR;
    private com.baidu.tieba.personCenter.a.c lCS;
    private f lCT;
    private d lCw;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fSo = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lCO = new e(tbPageContext, i.lDF);
        this.lCP = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.lDf);
        this.lCQ = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.lDg);
        this.lCR = new g(tbPageContext, n.lDQ);
        this.lCw = new d(tbPageContext, h.lDE);
        this.lCT = new f(tbPageContext, k.lDL);
        this.lCS = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.lDw);
        this.bhH.add(this.lCO);
        this.bhH.add(this.lCP);
        this.bhH.add(this.lCQ);
        this.bhH.add(this.lCR);
        this.bhH.add(this.lCw);
        this.bhH.add(this.lCS);
        this.bhH.add(this.lCT);
        bdTypeListView.addAdapters(this.bhH);
    }

    public void onChangeSkinType() {
        if (this.fSo != null && (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void dnP() {
        this.lCP.dnP();
    }

    public void dnQ() {
        this.lCP.destroy();
    }
}
