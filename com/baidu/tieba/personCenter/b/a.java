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
    private e kOI;
    private com.baidu.tieba.personCenter.a.a kOJ;
    private com.baidu.tieba.personCenter.a.b kOK;
    private g kOL;
    private com.baidu.tieba.personCenter.a.c kOM;
    private f kON;
    private d kOr;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.frv = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kOI = new e(tbPageContext, i.kPz);
        this.kOJ = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.kOZ);
        this.kOK = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.kPa);
        this.kOL = new g(tbPageContext, n.kPK);
        this.kOr = new d(tbPageContext, h.kPy);
        this.kON = new f(tbPageContext, k.kPF);
        this.kOM = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.kPq);
        this.aWf.add(this.kOI);
        this.aWf.add(this.kOJ);
        this.aWf.add(this.kOK);
        this.aWf.add(this.kOL);
        this.aWf.add(this.kOr);
        this.aWf.add(this.kOM);
        this.aWf.add(this.kON);
        bdTypeListView.addAdapters(this.aWf);
    }

    public void onChangeSkinType() {
        if (this.frv != null && (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void cVC() {
        this.kOJ.cVC();
    }

    public void cVD() {
        this.kOJ.destroy();
    }
}
