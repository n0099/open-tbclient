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
    private com.baidu.tieba.personCenter.a.b ffp;
    private h fjA;
    private j fjB;
    private e fjC;
    private k fjD;
    private d fjE;
    private com.baidu.tieba.person.a.c fjF;
    private p fjG;
    private m fjv;
    private b fjw;
    private i fjx;
    private a fjy;
    private c fjz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fjv = new m(tbPageContext);
        this.fjw = new b(tbPageContext);
        this.fjx = new i(tbPageContext);
        this.fjy = new a(tbPageContext);
        this.fjz = new c(tbPageContext);
        this.fjA = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fjB = new j(tbPageContext);
        this.fjC = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.flA);
        this.fjD = new k(tbPageContext);
        this.fjE = new d(tbPageContext);
        this.fjF = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.ffq);
        this.ffp = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.feY);
        this.fjG = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fjv);
        this.mAdapters.add(this.fjw);
        this.mAdapters.add(this.fjx);
        this.mAdapters.add(this.fjy);
        this.mAdapters.add(this.fjz);
        this.mAdapters.add(this.fjA);
        this.mAdapters.add(this.fjB);
        this.mAdapters.add(this.fjC);
        this.mAdapters.add(this.fjD);
        this.mAdapters.add(this.fjE);
        this.mAdapters.add(this.fjF);
        this.mAdapters.add(this.ffp);
        this.mAdapters.add(this.fjG);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fjF != null) {
            this.fjF.F(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fjG.setIsHost(z);
        this.fjx.setIsHost(z);
    }
}
