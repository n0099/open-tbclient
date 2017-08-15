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
    private com.baidu.tieba.personCenter.a.b fge;
    private m fkh;
    private b fki;
    private i fkj;
    private a fkk;
    private c fkl;
    private h fkm;
    private j fkn;
    private e fko;
    private k fkp;
    private d fkq;
    private com.baidu.tieba.person.a.c fkr;
    private p fks;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fkh = new m(tbPageContext);
        this.fki = new b(tbPageContext);
        this.fkj = new i(tbPageContext);
        this.fkk = new a(tbPageContext);
        this.fkl = new c(tbPageContext);
        this.fkm = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fkn = new j(tbPageContext);
        this.fko = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fmk);
        this.fkp = new k(tbPageContext);
        this.fkq = new d(tbPageContext);
        this.fkr = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.fgf);
        this.fge = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.ffM);
        this.fks = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fkh);
        this.mAdapters.add(this.fki);
        this.mAdapters.add(this.fkj);
        this.mAdapters.add(this.fkk);
        this.mAdapters.add(this.fkl);
        this.mAdapters.add(this.fkm);
        this.mAdapters.add(this.fkn);
        this.mAdapters.add(this.fko);
        this.mAdapters.add(this.fkp);
        this.mAdapters.add(this.fkq);
        this.mAdapters.add(this.fkr);
        this.mAdapters.add(this.fge);
        this.mAdapters.add(this.fks);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fkr != null) {
            this.fkr.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fks.setIsHost(z);
        this.fkj.setIsHost(z);
    }
}
