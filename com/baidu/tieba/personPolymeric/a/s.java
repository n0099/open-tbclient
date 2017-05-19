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
    private r eBQ;
    private c eBR;
    private k eBS;
    private a eBT;
    private e eBU;
    private j eBV;
    private o eBW;
    private g eBX;
    private p eBY;
    private f eBZ;
    private com.baidu.tieba.person.a.c eCa;
    private u eCb;
    private com.baidu.tieba.personCenter.a.b exS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eBQ = new r(tbPageContext);
        this.eBR = new c(tbPageContext);
        this.eBS = new k(tbPageContext);
        this.eBT = new a(tbPageContext);
        this.eBU = new e(tbPageContext);
        this.eBV = new j(tbPageContext);
        this.eBW = new o(tbPageContext);
        this.eBX = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.f.eDi);
        this.eBY = new p(tbPageContext);
        this.eBZ = new f(tbPageContext);
        this.eCa = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.exT);
        this.exS = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.b.b.eyF);
        this.eCb = new u(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.eBQ);
        this.mAdapters.add(this.eBR);
        this.mAdapters.add(this.eBS);
        this.mAdapters.add(this.eBT);
        this.mAdapters.add(this.eBU);
        this.mAdapters.add(this.eBV);
        this.mAdapters.add(this.eBW);
        this.mAdapters.add(this.eBX);
        this.mAdapters.add(this.eBY);
        this.mAdapters.add(this.eBZ);
        this.mAdapters.add(this.eCa);
        this.mAdapters.add(this.exS);
        this.mAdapters.add(this.eCb);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.eCa != null) {
            this.eCa.K(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.eCb.setIsHost(z);
        this.eBS.setIsHost(z);
    }
}
