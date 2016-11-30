package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private List<com.baidu.adp.widget.ListView.a> bRh = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eKm;
    private k ePA;
    private a ePB;
    private e ePC;
    private j ePD;
    private o ePE;
    private g ePF;
    private p ePG;
    private f ePH;
    private com.baidu.tieba.person.a.e ePI;
    private r ePy;
    private c ePz;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.ePy = new r(tbPageContext);
        this.ePz = new c(tbPageContext);
        this.ePA = new k(tbPageContext);
        this.ePB = new a(tbPageContext);
        this.ePC = new e(tbPageContext);
        this.ePD = new j(tbPageContext);
        this.ePE = new o(tbPageContext);
        this.ePF = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eQH);
        this.ePG = new p(tbPageContext);
        this.ePH = new f(tbPageContext);
        this.ePI = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.eKn);
        this.eKm = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eMa);
        this.bRh.add(this.ePy);
        this.bRh.add(this.ePz);
        this.bRh.add(this.ePA);
        this.bRh.add(this.ePB);
        this.bRh.add(this.ePC);
        this.bRh.add(this.ePD);
        this.bRh.add(this.ePE);
        this.bRh.add(this.ePF);
        this.bRh.add(this.ePG);
        this.bRh.add(this.ePH);
        this.bRh.add(this.ePI);
        this.bRh.add(this.eKm);
        C(tbPageContext);
        bdPersonListView.g(this.bRh);
    }

    public void C(TbPageContext tbPageContext) {
        if (EcommSwitchStatic.GN()) {
            com.baidu.tieba.person.data.e eVar = new com.baidu.tieba.person.data.e(0);
            eVar.GO = tbPageContext;
            eVar.bRh = this.bRh;
            eVar.aNX();
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.ePI != null) {
            this.ePI.K(onClickListener);
        }
    }
}
