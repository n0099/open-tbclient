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
    private com.baidu.tieba.person.a.a gaA;
    private m ggl;
    private b ggm;
    private i ggn;
    private a ggo;
    private c ggp;
    private h ggq;
    private e ggr;
    private k ggs;
    private d ggt;
    private com.baidu.tieba.person.a.d ggu;
    private p ggv;
    private BdPersonListView ggw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.ggw = bdPersonListView;
        this.ggl = new m(tbPageContext);
        this.ggm = new b(tbPageContext);
        this.ggn = new i(tbPageContext);
        this.ggo = new a(tbPageContext);
        this.ggp = new c(tbPageContext);
        this.ggq = new h(tbPageContext, tbPageContext.getUniqueId());
        this.ggr = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gis);
        this.ggs = new k(tbPageContext);
        this.ggt = new d(tbPageContext);
        this.ggu = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gaB);
        this.gaA = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gai);
        this.ggv = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.ggl);
        this.mAdapters.add(this.ggm);
        this.mAdapters.add(this.ggn);
        this.mAdapters.add(this.ggo);
        this.mAdapters.add(this.ggp);
        this.mAdapters.add(this.ggq);
        this.mAdapters.add(this.ggr);
        this.mAdapters.add(this.ggs);
        this.mAdapters.add(this.ggt);
        this.mAdapters.add(this.ggu);
        this.mAdapters.add(this.gaA);
        this.mAdapters.add(this.ggv);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.ggu != null) {
            this.ggu.M(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.ggv.setIsHost(z);
        this.ggn.setIsHost(z);
    }
}
