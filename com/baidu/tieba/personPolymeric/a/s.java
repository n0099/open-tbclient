package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private List<com.baidu.adp.widget.ListView.a> bOo = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eDN;
    private r eIZ;
    private c eJa;
    private k eJb;
    private a eJc;
    private e eJd;
    private j eJe;
    private o eJf;
    private g eJg;
    private p eJh;
    private f eJi;
    private com.baidu.tieba.person.a.e eJj;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eIZ = new r(tbPageContext);
        this.eJa = new c(tbPageContext);
        this.eJb = new k(tbPageContext);
        this.eJc = new a(tbPageContext);
        this.eJd = new e(tbPageContext);
        this.eJe = new j(tbPageContext);
        this.eJf = new o(tbPageContext);
        this.eJg = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eKj);
        this.eJh = new p(tbPageContext);
        this.eJi = new f(tbPageContext);
        this.eJj = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.eDO);
        this.eDN = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eFB);
        this.bOo.add(this.eIZ);
        this.bOo.add(this.eJa);
        this.bOo.add(this.eJb);
        this.bOo.add(this.eJc);
        this.bOo.add(this.eJd);
        this.bOo.add(this.eJe);
        this.bOo.add(this.eJf);
        this.bOo.add(this.eJg);
        this.bOo.add(this.eJh);
        this.bOo.add(this.eJi);
        this.bOo.add(this.eJj);
        this.bOo.add(this.eDN);
        A(tbPageContext);
        bdPersonListView.g(this.bOo);
    }

    public void A(TbPageContext tbPageContext) {
        if (EcommSwitchStatic.GK()) {
            com.baidu.tieba.person.data.e eVar = new com.baidu.tieba.person.data.e(0);
            eVar.GM = tbPageContext;
            eVar.bOo = this.bOo;
            eVar.aMe();
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eJj != null) {
            this.eJj.I(onClickListener);
        }
    }
}
