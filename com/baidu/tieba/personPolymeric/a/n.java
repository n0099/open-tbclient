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
    private com.baidu.tieba.person.a.a fPf;
    private m fUB;
    private b fUC;
    private i fUD;
    private a fUE;
    private c fUF;
    private h fUG;
    private e fUH;
    private k fUI;
    private d fUJ;
    private com.baidu.tieba.person.a.d fUK;
    private p fUL;
    private BdPersonListView fUM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fUM = bdPersonListView;
        this.fUB = new m(tbPageContext);
        this.fUC = new b(tbPageContext);
        this.fUD = new i(tbPageContext);
        this.fUE = new a(tbPageContext);
        this.fUF = new c(tbPageContext);
        this.fUG = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fUH = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fWJ);
        this.fUI = new k(tbPageContext);
        this.fUJ = new d(tbPageContext);
        this.fUK = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fPg);
        this.fPf = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fOM);
        this.fUL = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fUB);
        this.mAdapters.add(this.fUC);
        this.mAdapters.add(this.fUD);
        this.mAdapters.add(this.fUE);
        this.mAdapters.add(this.fUF);
        this.mAdapters.add(this.fUG);
        this.mAdapters.add(this.fUH);
        this.mAdapters.add(this.fUI);
        this.mAdapters.add(this.fUJ);
        this.mAdapters.add(this.fUK);
        this.mAdapters.add(this.fPf);
        this.mAdapters.add(this.fUL);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fUK != null) {
            this.fUK.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fUL.setIsHost(z);
        this.fUD.setIsHost(z);
    }
}
