package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class n {
    private com.baidu.tieba.person.a.a ghU;
    private BdPersonListView gnA;
    private m gnp;
    private b gnq;
    private i gnr;
    private a gns;
    private c gnt;
    private h gnu;
    private e gnv;
    private k gnw;
    private d gnx;
    private com.baidu.tieba.person.a.d gny;
    private p gnz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gnA = bdPersonListView;
        this.gnp = new m(tbPageContext);
        this.gnq = new b(tbPageContext);
        this.gnr = new i(tbPageContext);
        this.gns = new a(tbPageContext);
        this.gnt = new c(tbPageContext);
        this.gnu = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gnv = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gpC);
        this.gnw = new k(tbPageContext);
        this.gnx = new d(tbPageContext);
        this.gny = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ghV);
        this.ghU = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghD);
        this.gnz = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gnp);
        this.mAdapters.add(this.gnq);
        this.mAdapters.add(this.gnr);
        this.mAdapters.add(this.gns);
        this.mAdapters.add(this.gnt);
        this.mAdapters.add(this.gnu);
        this.mAdapters.add(this.gnv);
        this.mAdapters.add(this.gnw);
        this.mAdapters.add(this.gnx);
        this.mAdapters.add(this.gny);
        this.mAdapters.add(this.ghU);
        this.mAdapters.add(this.gnz);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.gny != null) {
            this.gny.K(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gnz.setIsHost(z);
        this.gnr.setIsHost(z);
    }
}
