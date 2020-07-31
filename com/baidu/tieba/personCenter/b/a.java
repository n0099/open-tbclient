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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeListView frv;
    private e kOG;
    private com.baidu.tieba.personCenter.a.a kOH;
    private com.baidu.tieba.personCenter.a.b kOI;
    private g kOJ;
    private com.baidu.tieba.personCenter.a.c kOK;
    private f kOL;
    private d kOp;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.frv = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kOG = new e(tbPageContext, i.kPx);
        this.kOH = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.kOX);
        this.kOI = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.kOY);
        this.kOJ = new g(tbPageContext, n.kPI);
        this.kOp = new d(tbPageContext, h.kPw);
        this.kOL = new f(tbPageContext, k.kPD);
        this.kOK = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.kPo);
        this.aWf.add(this.kOG);
        this.aWf.add(this.kOH);
        this.aWf.add(this.kOI);
        this.aWf.add(this.kOJ);
        this.aWf.add(this.kOp);
        this.aWf.add(this.kOK);
        this.aWf.add(this.kOL);
        bdTypeListView.addAdapters(this.aWf);
    }

    public void onChangeSkinType() {
        if (this.frv != null && (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void cVC() {
        this.kOH.cVC();
    }

    public void cVD() {
        this.kOH.destroy();
    }
}
