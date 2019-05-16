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
    private com.baidu.tieba.person.a.a ich;
    private c iiA;
    private h iiB;
    private e iiC;
    private k iiD;
    private d iiE;
    private com.baidu.tieba.person.a.d iiF;
    private p iiG;
    private BdPersonListView iiH;
    private m iiw;
    private b iix;
    private i iiy;
    private a iiz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.iiH = bdPersonListView;
        this.iiw = new m(tbPageContext);
        this.iix = new b(tbPageContext);
        this.iiy = new i(tbPageContext);
        this.iiz = new a(tbPageContext);
        this.iiA = new c(tbPageContext);
        this.iiB = new h(tbPageContext, tbPageContext.getUniqueId());
        this.iiC = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.ikC);
        this.iiD = new k(tbPageContext);
        this.iiE = new d(tbPageContext);
        this.iiF = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ici);
        this.ich = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibP);
        this.iiG = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.iiw);
        this.mAdapters.add(this.iix);
        this.mAdapters.add(this.iiy);
        this.mAdapters.add(this.iiz);
        this.mAdapters.add(this.iiA);
        this.mAdapters.add(this.iiB);
        this.mAdapters.add(this.iiC);
        this.mAdapters.add(this.iiD);
        this.mAdapters.add(this.iiE);
        this.mAdapters.add(this.iiF);
        this.mAdapters.add(this.ich);
        this.mAdapters.add(this.iiG);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.iiF != null) {
            this.iiF.Q(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.iiG.setIsHost(z);
        this.iiy.setIsHost(z);
    }
}
