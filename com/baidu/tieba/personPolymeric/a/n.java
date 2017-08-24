package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private com.baidu.tieba.personCenter.a.b fgg;
    private m fkj;
    private b fkk;
    private i fkl;
    private a fkm;
    private c fkn;
    private h fko;
    private j fkp;
    private e fkq;
    private k fkr;
    private d fks;
    private com.baidu.tieba.person.a.c fkt;
    private p fku;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fkj = new m(tbPageContext);
        this.fkk = new b(tbPageContext);
        this.fkl = new i(tbPageContext);
        this.fkm = new a(tbPageContext);
        this.fkn = new c(tbPageContext);
        this.fko = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fkp = new j(tbPageContext);
        this.fkq = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fmm);
        this.fkr = new k(tbPageContext);
        this.fks = new d(tbPageContext);
        this.fkt = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.fgh);
        this.fgg = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.ffO);
        this.fku = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fkj);
        this.mAdapters.add(this.fkk);
        this.mAdapters.add(this.fkl);
        this.mAdapters.add(this.fkm);
        this.mAdapters.add(this.fkn);
        this.mAdapters.add(this.fko);
        this.mAdapters.add(this.fkp);
        this.mAdapters.add(this.fkq);
        this.mAdapters.add(this.fkr);
        this.mAdapters.add(this.fks);
        this.mAdapters.add(this.fkt);
        this.mAdapters.add(this.fgg);
        this.mAdapters.add(this.fku);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fkt != null) {
            this.fkt.H(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fku.setIsHost(z);
        this.fkl.setIsHost(z);
    }
}
