package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private com.baidu.tieba.personCenter.a.b eBS;
    private r eGD;
    private c eGE;
    private k eGF;
    private a eGG;
    private e eGH;
    private j eGI;
    private o eGJ;
    private g eGK;
    private p eGL;
    private f eGM;
    private com.baidu.tieba.person.a.e eGN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eGD = new r(tbPageContext);
        this.eGE = new c(tbPageContext);
        this.eGF = new k(tbPageContext);
        this.eGG = new a(tbPageContext);
        this.eGH = new e(tbPageContext);
        this.eGI = new j(tbPageContext);
        this.eGJ = new o(tbPageContext);
        this.eGK = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eHO);
        this.eGL = new p(tbPageContext);
        this.eGM = new f(tbPageContext);
        this.eGN = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.eBT);
        this.eBS = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDh);
        this.mAdapters.add(this.eGD);
        this.mAdapters.add(this.eGE);
        this.mAdapters.add(this.eGF);
        this.mAdapters.add(this.eGG);
        this.mAdapters.add(this.eGH);
        this.mAdapters.add(this.eGI);
        this.mAdapters.add(this.eGJ);
        this.mAdapters.add(this.eGK);
        this.mAdapters.add(this.eGL);
        this.mAdapters.add(this.eGM);
        this.mAdapters.add(this.eGN);
        this.mAdapters.add(this.eBS);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eGN != null) {
            this.eGN.J(onClickListener);
        }
    }
}
