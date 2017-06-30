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
    private com.baidu.tieba.personCenter.a.b eQz;
    private r eUB;
    private c eUC;
    private k eUD;
    private a eUE;
    private e eUF;
    private j eUG;
    private o eUH;
    private g eUI;
    private p eUJ;
    private f eUK;
    private com.baidu.tieba.person.a.c eUL;
    private u eUM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public s(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eUB = new r(tbPageContext);
        this.eUC = new c(tbPageContext);
        this.eUD = new k(tbPageContext);
        this.eUE = new a(tbPageContext);
        this.eUF = new e(tbPageContext);
        this.eUG = new j(tbPageContext, tbPageContext.getUniqueId());
        this.eUH = new o(tbPageContext);
        this.eUI = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eWE);
        this.eUJ = new p(tbPageContext);
        this.eUK = new f(tbPageContext);
        this.eUL = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.eQA);
        this.eQz = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.eQg);
        this.eUM = new u(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.eUB);
        this.mAdapters.add(this.eUC);
        this.mAdapters.add(this.eUD);
        this.mAdapters.add(this.eUE);
        this.mAdapters.add(this.eUF);
        this.mAdapters.add(this.eUG);
        this.mAdapters.add(this.eUH);
        this.mAdapters.add(this.eUI);
        this.mAdapters.add(this.eUJ);
        this.mAdapters.add(this.eUK);
        this.mAdapters.add(this.eUL);
        this.mAdapters.add(this.eQz);
        this.mAdapters.add(this.eUM);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.eUL != null) {
            this.eUL.N(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.eUM.setIsHost(z);
        this.eUD.setIsHost(z);
    }
}
