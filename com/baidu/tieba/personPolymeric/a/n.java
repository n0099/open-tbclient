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
    private com.baidu.tieba.person.a.a gib;
    private m gnM;
    private b gnN;
    private i gnO;
    private a gnP;
    private c gnQ;
    private h gnR;
    private e gnS;
    private k gnT;
    private d gnU;
    private com.baidu.tieba.person.a.d gnV;
    private p gnW;
    private BdPersonListView gnX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gnX = bdPersonListView;
        this.gnM = new m(tbPageContext);
        this.gnN = new b(tbPageContext);
        this.gnO = new i(tbPageContext);
        this.gnP = new a(tbPageContext);
        this.gnQ = new c(tbPageContext);
        this.gnR = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gnS = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gpS);
        this.gnT = new k(tbPageContext);
        this.gnU = new d(tbPageContext);
        this.gnV = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gic);
        this.gib = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghJ);
        this.gnW = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gnM);
        this.mAdapters.add(this.gnN);
        this.mAdapters.add(this.gnO);
        this.mAdapters.add(this.gnP);
        this.mAdapters.add(this.gnQ);
        this.mAdapters.add(this.gnR);
        this.mAdapters.add(this.gnS);
        this.mAdapters.add(this.gnT);
        this.mAdapters.add(this.gnU);
        this.mAdapters.add(this.gnV);
        this.mAdapters.add(this.gib);
        this.mAdapters.add(this.gnW);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.gnV != null) {
            this.gnV.M(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gnW.setIsHost(z);
        this.gnO.setIsHost(z);
    }
}
