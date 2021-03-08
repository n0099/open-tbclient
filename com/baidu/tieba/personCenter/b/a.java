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
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeListView gAY;
    private e mvE;
    private com.baidu.tieba.personCenter.a.a mvF;
    private com.baidu.tieba.personCenter.a.b mvG;
    private g mvH;
    private com.baidu.tieba.personCenter.a.c mvI;
    private f mvJ;
    private d mvm;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gAY = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mvE = new e(tbPageContext, i.mwu);
        this.mvF = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mvV);
        this.mvG = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mvW);
        this.mvH = new g(tbPageContext, n.mwF);
        this.mvm = new d(tbPageContext, h.mwt);
        this.mvJ = new f(tbPageContext, k.mwA);
        this.mvI = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mwm);
        this.boS.add(this.mvE);
        this.boS.add(this.mvF);
        this.boS.add(this.mvG);
        this.boS.add(this.mvH);
        this.boS.add(this.mvm);
        this.boS.add(this.mvI);
        this.boS.add(this.mvJ);
        bdTypeListView.addAdapters(this.boS);
    }

    public void onChangeSkinType() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void dwO() {
        this.mvF.dwO();
    }

    public void dwP() {
        this.mvF.destroy();
    }
}
