package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private r eCP;
    private c eCQ;
    private k eCR;
    private a eCS;
    private e eCT;
    private j eCU;
    private o eCV;
    private g eCW;
    private p eCX;
    private f eCY;
    private com.baidu.tieba.person.a.e eCZ;
    private com.baidu.tieba.personCenter.a.b exW;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eCP = new r(tbPageContext);
        this.eCQ = new c(tbPageContext);
        this.eCR = new k(tbPageContext);
        this.eCS = new a(tbPageContext);
        this.eCT = new e(tbPageContext);
        this.eCU = new j(tbPageContext);
        this.eCV = new o(tbPageContext);
        this.eCW = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eEa);
        this.eCX = new p(tbPageContext);
        this.eCY = new f(tbPageContext);
        this.eCZ = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.exX);
        this.exW = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.ezv);
        this.mAdapters.add(this.eCP);
        this.mAdapters.add(this.eCQ);
        this.mAdapters.add(this.eCR);
        this.mAdapters.add(this.eCS);
        this.mAdapters.add(this.eCT);
        this.mAdapters.add(this.eCU);
        this.mAdapters.add(this.eCV);
        this.mAdapters.add(this.eCW);
        this.mAdapters.add(this.eCX);
        this.mAdapters.add(this.eCY);
        this.mAdapters.add(this.eCZ);
        this.mAdapters.add(this.exW);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.eCZ != null) {
            this.eCZ.K(onClickListener);
        }
    }
}
