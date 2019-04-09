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
    private com.baidu.tieba.person.a.a hKi;
    private m hPK;
    private b hPL;
    private i hPM;
    private a hPN;
    private c hPO;
    private h hPP;
    private e hPQ;
    private k hPR;
    private d hPS;
    private com.baidu.tieba.person.a.d hPT;
    private p hPU;
    private BdPersonListView hPV;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.hPV = bdPersonListView;
        this.hPK = new m(tbPageContext);
        this.hPL = new b(tbPageContext);
        this.hPM = new i(tbPageContext);
        this.hPN = new a(tbPageContext);
        this.hPO = new c(tbPageContext);
        this.hPP = new h(tbPageContext, tbPageContext.getUniqueId());
        this.hPQ = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.hRQ);
        this.hPR = new k(tbPageContext);
        this.hPS = new d(tbPageContext);
        this.hPT = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.hKj);
        this.hKi = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.hJQ);
        this.hPU = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.hPK);
        this.mAdapters.add(this.hPL);
        this.mAdapters.add(this.hPM);
        this.mAdapters.add(this.hPN);
        this.mAdapters.add(this.hPO);
        this.mAdapters.add(this.hPP);
        this.mAdapters.add(this.hPQ);
        this.mAdapters.add(this.hPR);
        this.mAdapters.add(this.hPS);
        this.mAdapters.add(this.hPT);
        this.mAdapters.add(this.hKi);
        this.mAdapters.add(this.hPU);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.hPT != null) {
            this.hPT.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.hPU.setIsHost(z);
        this.hPM.setIsHost(z);
    }
}
