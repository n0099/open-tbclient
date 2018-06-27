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
    private com.baidu.tieba.person.a.a fTh;
    private m fYD;
    private b fYE;
    private i fYF;
    private a fYG;
    private c fYH;
    private h fYI;
    private e fYJ;
    private k fYK;
    private d fYL;
    private com.baidu.tieba.person.a.d fYM;
    private p fYN;
    private BdPersonListView fYO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fYO = bdPersonListView;
        this.fYD = new m(tbPageContext);
        this.fYE = new b(tbPageContext);
        this.fYF = new i(tbPageContext);
        this.fYG = new a(tbPageContext);
        this.fYH = new c(tbPageContext);
        this.fYI = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fYJ = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gaJ);
        this.fYK = new k(tbPageContext);
        this.fYL = new d(tbPageContext);
        this.fYM = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fTi);
        this.fTh = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fSP);
        this.fYN = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fYD);
        this.mAdapters.add(this.fYE);
        this.mAdapters.add(this.fYF);
        this.mAdapters.add(this.fYG);
        this.mAdapters.add(this.fYH);
        this.mAdapters.add(this.fYI);
        this.mAdapters.add(this.fYJ);
        this.mAdapters.add(this.fYK);
        this.mAdapters.add(this.fYL);
        this.mAdapters.add(this.fYM);
        this.mAdapters.add(this.fTh);
        this.mAdapters.add(this.fYN);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.fYM != null) {
            this.fYM.P(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fYN.setIsHost(z);
        this.fYF.setIsHost(z);
    }
}
