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
    private com.baidu.tieba.person.a.a gig;
    private m gnA;
    private b gnB;
    private i gnC;
    private a gnD;
    private c gnE;
    private h gnF;
    private e gnG;
    private k gnH;
    private d gnI;
    private com.baidu.tieba.person.a.d gnJ;
    private p gnK;
    private BdPersonListView gnL;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gnL = bdPersonListView;
        this.gnA = new m(tbPageContext);
        this.gnB = new b(tbPageContext);
        this.gnC = new i(tbPageContext);
        this.gnD = new a(tbPageContext);
        this.gnE = new c(tbPageContext);
        this.gnF = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gnG = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gpN);
        this.gnH = new k(tbPageContext);
        this.gnI = new d(tbPageContext);
        this.gnJ = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gih);
        this.gig = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghO);
        this.gnK = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gnA);
        this.mAdapters.add(this.gnB);
        this.mAdapters.add(this.gnC);
        this.mAdapters.add(this.gnD);
        this.mAdapters.add(this.gnE);
        this.mAdapters.add(this.gnF);
        this.mAdapters.add(this.gnG);
        this.mAdapters.add(this.gnH);
        this.mAdapters.add(this.gnI);
        this.mAdapters.add(this.gnJ);
        this.mAdapters.add(this.gig);
        this.mAdapters.add(this.gnK);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.gnJ != null) {
            this.gnJ.K(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gnK.setIsHost(z);
        this.gnC.setIsHost(z);
    }
}
