package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private List<com.baidu.adp.widget.ListView.a> bOr = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eBK;
    private r eGV;
    private c eGW;
    private k eGX;
    private a eGY;
    private e eGZ;
    private j eHa;
    private o eHb;
    private g eHc;
    private p eHd;
    private f eHe;
    private com.baidu.tieba.person.a.e eHf;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eGV = new r(tbPageContext);
        this.eGW = new c(tbPageContext);
        this.eGX = new k(tbPageContext);
        this.eGY = new a(tbPageContext);
        this.eGZ = new e(tbPageContext);
        this.eHa = new j(tbPageContext);
        this.eHb = new o(tbPageContext);
        this.eHc = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eIf);
        this.eHd = new p(tbPageContext);
        this.eHe = new f(tbPageContext);
        this.eHf = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.eBL);
        this.eBK = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDy);
        this.bOr.add(this.eGV);
        this.bOr.add(this.eGW);
        this.bOr.add(this.eGX);
        this.bOr.add(this.eGY);
        this.bOr.add(this.eGZ);
        this.bOr.add(this.eHa);
        this.bOr.add(this.eHb);
        this.bOr.add(this.eHc);
        this.bOr.add(this.eHd);
        this.bOr.add(this.eHe);
        this.bOr.add(this.eHf);
        this.bOr.add(this.eBK);
        x(tbPageContext);
        bdPersonListView.g(this.bOr);
    }

    public void x(TbPageContext tbPageContext) {
        if (EcommSwitchStatic.GL()) {
            com.baidu.tieba.person.data.e eVar = new com.baidu.tieba.person.data.e(0);
            eVar.GM = tbPageContext;
            eVar.bOr = this.bOr;
            eVar.aLC();
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.eHf != null) {
            this.eHf.J(onClickListener);
        }
    }
}
