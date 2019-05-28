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
    private com.baidu.tieba.person.a.a ick;
    private b iiA;
    private i iiB;
    private a iiC;
    private c iiD;
    private h iiE;
    private e iiF;
    private k iiG;
    private d iiH;
    private com.baidu.tieba.person.a.d iiI;
    private p iiJ;
    private BdPersonListView iiK;
    private m iiz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.iiK = bdPersonListView;
        this.iiz = new m(tbPageContext);
        this.iiA = new b(tbPageContext);
        this.iiB = new i(tbPageContext);
        this.iiC = new a(tbPageContext);
        this.iiD = new c(tbPageContext);
        this.iiE = new h(tbPageContext, tbPageContext.getUniqueId());
        this.iiF = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.ikF);
        this.iiG = new k(tbPageContext);
        this.iiH = new d(tbPageContext);
        this.iiI = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.icl);
        this.ick = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibS);
        this.iiJ = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.iiz);
        this.mAdapters.add(this.iiA);
        this.mAdapters.add(this.iiB);
        this.mAdapters.add(this.iiC);
        this.mAdapters.add(this.iiD);
        this.mAdapters.add(this.iiE);
        this.mAdapters.add(this.iiF);
        this.mAdapters.add(this.iiG);
        this.mAdapters.add(this.iiH);
        this.mAdapters.add(this.iiI);
        this.mAdapters.add(this.ick);
        this.mAdapters.add(this.iiJ);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.iiI != null) {
            this.iiI.Q(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.iiJ.setIsHost(z);
        this.iiB.setIsHost(z);
    }
}
