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
    private com.baidu.tieba.person.a.a icl;
    private m iiA;
    private b iiB;
    private i iiC;
    private a iiD;
    private c iiE;
    private h iiF;
    private e iiG;
    private k iiH;
    private d iiI;
    private com.baidu.tieba.person.a.d iiJ;
    private p iiK;
    private BdPersonListView iiL;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.iiL = bdPersonListView;
        this.iiA = new m(tbPageContext);
        this.iiB = new b(tbPageContext);
        this.iiC = new i(tbPageContext);
        this.iiD = new a(tbPageContext);
        this.iiE = new c(tbPageContext);
        this.iiF = new h(tbPageContext, tbPageContext.getUniqueId());
        this.iiG = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.ikG);
        this.iiH = new k(tbPageContext);
        this.iiI = new d(tbPageContext);
        this.iiJ = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.icm);
        this.icl = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibT);
        this.iiK = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.iiA);
        this.mAdapters.add(this.iiB);
        this.mAdapters.add(this.iiC);
        this.mAdapters.add(this.iiD);
        this.mAdapters.add(this.iiE);
        this.mAdapters.add(this.iiF);
        this.mAdapters.add(this.iiG);
        this.mAdapters.add(this.iiH);
        this.mAdapters.add(this.iiI);
        this.mAdapters.add(this.iiJ);
        this.mAdapters.add(this.icl);
        this.mAdapters.add(this.iiK);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.iiJ != null) {
            this.iiJ.Q(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.iiK.setIsHost(z);
        this.iiC.setIsHost(z);
    }
}
