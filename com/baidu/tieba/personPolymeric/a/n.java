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
    private com.baidu.tieba.person.a.a gqp;
    private m gwc;
    private b gwd;
    private i gwe;
    private a gwf;
    private c gwg;
    private h gwh;
    private e gwi;
    private k gwj;
    private d gwk;
    private com.baidu.tieba.person.a.d gwl;
    private p gwm;
    private BdPersonListView gwn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gwn = bdPersonListView;
        this.gwc = new m(tbPageContext);
        this.gwd = new b(tbPageContext);
        this.gwe = new i(tbPageContext);
        this.gwf = new a(tbPageContext);
        this.gwg = new c(tbPageContext);
        this.gwh = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gwi = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gyi);
        this.gwj = new k(tbPageContext);
        this.gwk = new d(tbPageContext);
        this.gwl = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gqq);
        this.gqp = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gpX);
        this.gwm = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gwc);
        this.mAdapters.add(this.gwd);
        this.mAdapters.add(this.gwe);
        this.mAdapters.add(this.gwf);
        this.mAdapters.add(this.gwg);
        this.mAdapters.add(this.gwh);
        this.mAdapters.add(this.gwi);
        this.mAdapters.add(this.gwj);
        this.mAdapters.add(this.gwk);
        this.mAdapters.add(this.gwl);
        this.mAdapters.add(this.gqp);
        this.mAdapters.add(this.gwm);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gwl != null) {
            this.gwl.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gwm.setIsHost(z);
        this.gwe.setIsHost(z);
    }
}
