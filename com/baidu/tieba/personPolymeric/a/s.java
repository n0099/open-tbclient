package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private r eEn;
    private c eEo;
    private k eEp;
    private a eEq;
    private e eEr;
    private j eEs;
    private o eEt;
    private g eEu;
    private p eEv;
    private f eEw;
    private com.baidu.tieba.person.a.e eEx;
    private com.baidu.tieba.personCenter.a.b ezC;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eEn = new r(tbPageContext);
        this.eEo = new c(tbPageContext);
        this.eEp = new k(tbPageContext);
        this.eEq = new a(tbPageContext);
        this.eEr = new e(tbPageContext);
        this.eEs = new j(tbPageContext);
        this.eEt = new o(tbPageContext);
        this.eEu = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eFy);
        this.eEv = new p(tbPageContext);
        this.eEw = new f(tbPageContext);
        this.eEx = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.ezD);
        this.ezC = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eAR);
        this.mAdapters.add(this.eEn);
        this.mAdapters.add(this.eEo);
        this.mAdapters.add(this.eEp);
        this.mAdapters.add(this.eEq);
        this.mAdapters.add(this.eEr);
        this.mAdapters.add(this.eEs);
        this.mAdapters.add(this.eEt);
        this.mAdapters.add(this.eEu);
        this.mAdapters.add(this.eEv);
        this.mAdapters.add(this.eEw);
        this.mAdapters.add(this.eEx);
        this.mAdapters.add(this.ezC);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eEx != null) {
            this.eEx.J(onClickListener);
        }
    }
}
