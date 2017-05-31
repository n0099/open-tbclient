package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private j buZ;
    private com.baidu.tieba.personCenter.a.b eGK;
    private r eKD;
    private c eKE;
    private k eKF;
    private a eKG;
    private e eKH;
    private o eKI;
    private g eKJ;
    private p eKK;
    private f eKL;
    private com.baidu.tieba.person.a.c eKM;
    private u eKN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eKD = new r(tbPageContext);
        this.eKE = new c(tbPageContext);
        this.eKF = new k(tbPageContext);
        this.eKG = new a(tbPageContext);
        this.eKH = new e(tbPageContext);
        this.buZ = new j(tbPageContext, tbPageContext.getUniqueId());
        this.eKI = new o(tbPageContext);
        this.eKJ = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eMv);
        this.eKK = new p(tbPageContext);
        this.eKL = new f(tbPageContext);
        this.eKM = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.eGL);
        this.eGK = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.eGy);
        this.eKN = new u(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.eKD);
        this.mAdapters.add(this.eKE);
        this.mAdapters.add(this.eKF);
        this.mAdapters.add(this.eKG);
        this.mAdapters.add(this.eKH);
        this.mAdapters.add(this.buZ);
        this.mAdapters.add(this.eKI);
        this.mAdapters.add(this.eKJ);
        this.mAdapters.add(this.eKK);
        this.mAdapters.add(this.eKL);
        this.mAdapters.add(this.eKM);
        this.mAdapters.add(this.eGK);
        this.mAdapters.add(this.eKN);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.eKM != null) {
            this.eKM.M(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.eKN.setIsHost(z);
        this.eKF.setIsHost(z);
    }
}
