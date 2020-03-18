package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.c.g;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.tieba.personCenter.c.j;
import com.baidu.tieba.personCenter.c.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private BdTypeListView ekE;
    private d jiG;
    private com.baidu.tieba.personCenter.a.a jiH;
    private com.baidu.tieba.personCenter.a.b jiI;
    private f jiJ;
    private e jiK;
    private com.baidu.tieba.personCenter.a.c jis;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ekE = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jiG = new d(tbPageContext, h.jjs);
        this.jiH = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.jiY);
        this.jiI = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.jiZ);
        this.jiJ = new f(tbPageContext, m.jjD);
        this.jis = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jjr);
        this.jiK = new e(tbPageContext, j.jjy);
        this.asP.add(this.jiG);
        this.asP.add(this.jiH);
        this.asP.add(this.jiI);
        this.asP.add(this.jiJ);
        this.asP.add(this.jis);
        this.asP.add(this.jiK);
        bdTypeListView.addAdapters(this.asP);
    }

    public void onChangeSkinType() {
        if (this.ekE != null && (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void cvx() {
        this.jiH.cvx();
    }

    public void cvy() {
        this.jiH.destroy();
    }
}
