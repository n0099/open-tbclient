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
    private com.baidu.tieba.person.a.a fCF;
    private m fIa;
    private b fIb;
    private i fIc;
    private a fId;
    private c fIe;
    private h fIf;
    private e fIg;
    private k fIh;
    private d fIi;
    private com.baidu.tieba.person.a.d fIj;
    private p fIk;
    private BdPersonListView fIl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fIl = bdPersonListView;
        this.fIa = new m(tbPageContext);
        this.fIb = new b(tbPageContext);
        this.fIc = new i(tbPageContext);
        this.fId = new a(tbPageContext);
        this.fIe = new c(tbPageContext);
        this.fIf = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fIg = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fKr);
        this.fIh = new k(tbPageContext);
        this.fIi = new d(tbPageContext);
        this.fIj = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fCG);
        this.fCF = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fCm);
        this.fIk = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fIa);
        this.mAdapters.add(this.fIb);
        this.mAdapters.add(this.fIc);
        this.mAdapters.add(this.fId);
        this.mAdapters.add(this.fIe);
        this.mAdapters.add(this.fIf);
        this.mAdapters.add(this.fIg);
        this.mAdapters.add(this.fIh);
        this.mAdapters.add(this.fIi);
        this.mAdapters.add(this.fIj);
        this.mAdapters.add(this.fCF);
        this.mAdapters.add(this.fIk);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fIj != null) {
            this.fIj.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fIk.setIsHost(z);
        this.fIc.setIsHost(z);
    }
}
