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
    private com.baidu.tieba.person.a.a fDL;
    private m fJg;
    private b fJh;
    private i fJi;
    private a fJj;
    private c fJk;
    private h fJl;
    private e fJm;
    private k fJn;
    private d fJo;
    private com.baidu.tieba.person.a.d fJp;
    private p fJq;
    private BdPersonListView fJr;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fJr = bdPersonListView;
        this.fJg = new m(tbPageContext);
        this.fJh = new b(tbPageContext);
        this.fJi = new i(tbPageContext);
        this.fJj = new a(tbPageContext);
        this.fJk = new c(tbPageContext);
        this.fJl = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fJm = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fLx);
        this.fJn = new k(tbPageContext);
        this.fJo = new d(tbPageContext);
        this.fJp = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fDM);
        this.fDL = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fDs);
        this.fJq = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fJg);
        this.mAdapters.add(this.fJh);
        this.mAdapters.add(this.fJi);
        this.mAdapters.add(this.fJj);
        this.mAdapters.add(this.fJk);
        this.mAdapters.add(this.fJl);
        this.mAdapters.add(this.fJm);
        this.mAdapters.add(this.fJn);
        this.mAdapters.add(this.fJo);
        this.mAdapters.add(this.fJp);
        this.mAdapters.add(this.fDL);
        this.mAdapters.add(this.fJq);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fJp != null) {
            this.fJp.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fJq.setIsHost(z);
        this.fJi.setIsHost(z);
    }
}
