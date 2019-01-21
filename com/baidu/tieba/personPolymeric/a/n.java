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
    private i gAa;
    private a gAb;
    private c gAc;
    private h gAd;
    private e gAe;
    private k gAf;
    private d gAg;
    private com.baidu.tieba.person.a.d gAh;
    private p gAi;
    private BdPersonListView gAj;
    private com.baidu.tieba.person.a.a gul;
    private m gzY;
    private b gzZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gAj = bdPersonListView;
        this.gzY = new m(tbPageContext);
        this.gzZ = new b(tbPageContext);
        this.gAa = new i(tbPageContext);
        this.gAb = new a(tbPageContext);
        this.gAc = new c(tbPageContext);
        this.gAd = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gAe = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gCe);
        this.gAf = new k(tbPageContext);
        this.gAg = new d(tbPageContext);
        this.gAh = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gum);
        this.gul = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gtT);
        this.gAi = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gzY);
        this.mAdapters.add(this.gzZ);
        this.mAdapters.add(this.gAa);
        this.mAdapters.add(this.gAb);
        this.mAdapters.add(this.gAc);
        this.mAdapters.add(this.gAd);
        this.mAdapters.add(this.gAe);
        this.mAdapters.add(this.gAf);
        this.mAdapters.add(this.gAg);
        this.mAdapters.add(this.gAh);
        this.mAdapters.add(this.gul);
        this.mAdapters.add(this.gAi);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gAh != null) {
            this.gAh.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gAi.setIsHost(z);
        this.gAa.setIsHost(z);
    }
}
