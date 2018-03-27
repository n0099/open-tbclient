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
    private com.baidu.tieba.person.a.a gil;
    private m gnF;
    private b gnG;
    private i gnH;
    private a gnI;
    private c gnJ;
    private h gnK;
    private e gnL;
    private k gnM;
    private d gnN;
    private com.baidu.tieba.person.a.d gnO;
    private p gnP;
    private BdPersonListView gnQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gnQ = bdPersonListView;
        this.gnF = new m(tbPageContext);
        this.gnG = new b(tbPageContext);
        this.gnH = new i(tbPageContext);
        this.gnI = new a(tbPageContext);
        this.gnJ = new c(tbPageContext);
        this.gnK = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gnL = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gpS);
        this.gnM = new k(tbPageContext);
        this.gnN = new d(tbPageContext);
        this.gnO = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gim);
        this.gil = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghT);
        this.gnP = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gnF);
        this.mAdapters.add(this.gnG);
        this.mAdapters.add(this.gnH);
        this.mAdapters.add(this.gnI);
        this.mAdapters.add(this.gnJ);
        this.mAdapters.add(this.gnK);
        this.mAdapters.add(this.gnL);
        this.mAdapters.add(this.gnM);
        this.mAdapters.add(this.gnN);
        this.mAdapters.add(this.gnO);
        this.mAdapters.add(this.gil);
        this.mAdapters.add(this.gnP);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.gnO != null) {
            this.gnO.K(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gnP.setIsHost(z);
        this.gnH.setIsHost(z);
    }
}
