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
    private com.baidu.tieba.personCenter.a.b few;
    private m fiC;
    private b fiD;
    private i fiE;
    private a fiF;
    private c fiG;
    private h fiH;
    private j fiI;
    private e fiJ;
    private k fiK;
    private d fiL;
    private com.baidu.tieba.person.a.c fiM;
    private p fiN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fiC = new m(tbPageContext);
        this.fiD = new b(tbPageContext);
        this.fiE = new i(tbPageContext);
        this.fiF = new a(tbPageContext);
        this.fiG = new c(tbPageContext);
        this.fiH = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fiI = new j(tbPageContext);
        this.fiJ = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fkH);
        this.fiK = new k(tbPageContext);
        this.fiL = new d(tbPageContext);
        this.fiM = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.fex);
        this.few = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.fef);
        this.fiN = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fiC);
        this.mAdapters.add(this.fiD);
        this.mAdapters.add(this.fiE);
        this.mAdapters.add(this.fiF);
        this.mAdapters.add(this.fiG);
        this.mAdapters.add(this.fiH);
        this.mAdapters.add(this.fiI);
        this.mAdapters.add(this.fiJ);
        this.mAdapters.add(this.fiK);
        this.mAdapters.add(this.fiL);
        this.mAdapters.add(this.fiM);
        this.mAdapters.add(this.few);
        this.mAdapters.add(this.fiN);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fiM != null) {
            this.fiM.F(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fiN.setIsHost(z);
        this.fiE.setIsHost(z);
    }
}
