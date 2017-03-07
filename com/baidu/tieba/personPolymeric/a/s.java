package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private com.baidu.tieba.personCenter.a.b eBw;
    private f eGA;
    private com.baidu.tieba.person.a.e eGB;
    private r eGr;
    private c eGs;
    private k eGt;
    private a eGu;
    private e eGv;
    private j eGw;
    private o eGx;
    private g eGy;
    private p eGz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eGr = new r(tbPageContext);
        this.eGs = new c(tbPageContext);
        this.eGt = new k(tbPageContext);
        this.eGu = new a(tbPageContext);
        this.eGv = new e(tbPageContext);
        this.eGw = new j(tbPageContext);
        this.eGx = new o(tbPageContext);
        this.eGy = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eHC);
        this.eGz = new p(tbPageContext);
        this.eGA = new f(tbPageContext);
        this.eGB = new com.baidu.tieba.person.a.e(tbPageContext, com.baidu.tieba.person.a.g.eBx);
        this.eBw = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eCU);
        this.mAdapters.add(this.eGr);
        this.mAdapters.add(this.eGs);
        this.mAdapters.add(this.eGt);
        this.mAdapters.add(this.eGu);
        this.mAdapters.add(this.eGv);
        this.mAdapters.add(this.eGw);
        this.mAdapters.add(this.eGx);
        this.mAdapters.add(this.eGy);
        this.mAdapters.add(this.eGz);
        this.mAdapters.add(this.eGA);
        this.mAdapters.add(this.eGB);
        this.mAdapters.add(this.eBw);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.eGB != null) {
            this.eGB.I(onClickListener);
        }
    }
}
