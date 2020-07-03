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
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeListView fml;
    private e kFE;
    private com.baidu.tieba.personCenter.a.a kFF;
    private com.baidu.tieba.personCenter.a.b kFG;
    private g kFH;
    private com.baidu.tieba.personCenter.a.c kFI;
    private f kFJ;
    private d kFn;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fml = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kFE = new e(tbPageContext, i.kGw);
        this.kFF = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.kFW);
        this.kFG = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.kFX);
        this.kFH = new g(tbPageContext, n.kGH);
        this.kFn = new d(tbPageContext, h.kGv);
        this.kFJ = new f(tbPageContext, k.kGC);
        this.kFI = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.kGn);
        this.aUP.add(this.kFE);
        this.aUP.add(this.kFF);
        this.aUP.add(this.kFG);
        this.aUP.add(this.kFH);
        this.aUP.add(this.kFn);
        this.aUP.add(this.kFI);
        this.aUP.add(this.kFJ);
        bdTypeListView.addAdapters(this.aUP);
    }

    public void onChangeSkinType() {
        if (this.fml != null && (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void cRL() {
        this.kFF.cRL();
    }

    public void cRM() {
        this.kFF.destroy();
    }
}
