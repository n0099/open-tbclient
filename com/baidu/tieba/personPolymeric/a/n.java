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
    private com.baidu.tieba.personCenter.a.b fcZ;
    private m fha;
    private b fhb;
    private i fhc;
    private a fhd;
    private c fhe;
    private h fhf;
    private j fhg;
    private e fhh;
    private k fhi;
    private d fhj;
    private com.baidu.tieba.person.a.c fhk;
    private p fhl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fha = new m(tbPageContext);
        this.fhb = new b(tbPageContext);
        this.fhc = new i(tbPageContext);
        this.fhd = new a(tbPageContext);
        this.fhe = new c(tbPageContext);
        this.fhf = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fhg = new j(tbPageContext);
        this.fhh = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fjf);
        this.fhi = new k(tbPageContext);
        this.fhj = new d(tbPageContext);
        this.fhk = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.fda);
        this.fcZ = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.fcH);
        this.fhl = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fha);
        this.mAdapters.add(this.fhb);
        this.mAdapters.add(this.fhc);
        this.mAdapters.add(this.fhd);
        this.mAdapters.add(this.fhe);
        this.mAdapters.add(this.fhf);
        this.mAdapters.add(this.fhg);
        this.mAdapters.add(this.fhh);
        this.mAdapters.add(this.fhi);
        this.mAdapters.add(this.fhj);
        this.mAdapters.add(this.fhk);
        this.mAdapters.add(this.fcZ);
        this.mAdapters.add(this.fhl);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fhk != null) {
            this.fhk.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fhl.setIsHost(z);
        this.fhc.setIsHost(z);
    }
}
