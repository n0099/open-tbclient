package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class n {
    private com.baidu.tieba.person.a.a hKh;
    private m hPJ;
    private b hPK;
    private i hPL;
    private a hPM;
    private c hPN;
    private h hPO;
    private e hPP;
    private k hPQ;
    private d hPR;
    private com.baidu.tieba.person.a.d hPS;
    private p hPT;
    private BdPersonListView hPU;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.hPU = bdPersonListView;
        this.hPJ = new m(tbPageContext);
        this.hPK = new b(tbPageContext);
        this.hPL = new i(tbPageContext);
        this.hPM = new a(tbPageContext);
        this.hPN = new c(tbPageContext);
        this.hPO = new h(tbPageContext, tbPageContext.getUniqueId());
        this.hPP = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.hRP);
        this.hPQ = new k(tbPageContext);
        this.hPR = new d(tbPageContext);
        this.hPS = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.hKi);
        this.hKh = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.hJP);
        this.hPT = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.hPJ);
        this.mAdapters.add(this.hPK);
        this.mAdapters.add(this.hPL);
        this.mAdapters.add(this.hPM);
        this.mAdapters.add(this.hPN);
        this.mAdapters.add(this.hPO);
        this.mAdapters.add(this.hPP);
        this.mAdapters.add(this.hPQ);
        this.mAdapters.add(this.hPR);
        this.mAdapters.add(this.hPS);
        this.mAdapters.add(this.hKh);
        this.mAdapters.add(this.hPT);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.hPS != null) {
            this.hPS.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.hPT.setIsHost(z);
        this.hPL.setIsHost(z);
    }
}
