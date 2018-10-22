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
    private com.baidu.tieba.person.a.a gic;
    private m gnN;
    private b gnO;
    private i gnP;
    private a gnQ;
    private c gnR;
    private h gnS;
    private e gnT;
    private k gnU;
    private d gnV;
    private com.baidu.tieba.person.a.d gnW;
    private p gnX;
    private BdPersonListView gnY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gnY = bdPersonListView;
        this.gnN = new m(tbPageContext);
        this.gnO = new b(tbPageContext);
        this.gnP = new i(tbPageContext);
        this.gnQ = new a(tbPageContext);
        this.gnR = new c(tbPageContext);
        this.gnS = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gnT = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gpT);
        this.gnU = new k(tbPageContext);
        this.gnV = new d(tbPageContext);
        this.gnW = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gie);
        this.gic = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghK);
        this.gnX = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gnN);
        this.mAdapters.add(this.gnO);
        this.mAdapters.add(this.gnP);
        this.mAdapters.add(this.gnQ);
        this.mAdapters.add(this.gnR);
        this.mAdapters.add(this.gnS);
        this.mAdapters.add(this.gnT);
        this.mAdapters.add(this.gnU);
        this.mAdapters.add(this.gnV);
        this.mAdapters.add(this.gnW);
        this.mAdapters.add(this.gic);
        this.mAdapters.add(this.gnX);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.gnW != null) {
            this.gnW.M(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gnX.setIsHost(z);
        this.gnP.setIsHost(z);
    }
}
