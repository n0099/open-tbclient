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
    private a gAa;
    private c gAb;
    private h gAc;
    private e gAd;
    private k gAe;
    private d gAf;
    private com.baidu.tieba.person.a.d gAg;
    private p gAh;
    private BdPersonListView gAi;
    private com.baidu.tieba.person.a.a guk;
    private m gzX;
    private b gzY;
    private i gzZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gAi = bdPersonListView;
        this.gzX = new m(tbPageContext);
        this.gzY = new b(tbPageContext);
        this.gzZ = new i(tbPageContext);
        this.gAa = new a(tbPageContext);
        this.gAb = new c(tbPageContext);
        this.gAc = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gAd = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gCd);
        this.gAe = new k(tbPageContext);
        this.gAf = new d(tbPageContext);
        this.gAg = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gul);
        this.guk = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gtS);
        this.gAh = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gzX);
        this.mAdapters.add(this.gzY);
        this.mAdapters.add(this.gzZ);
        this.mAdapters.add(this.gAa);
        this.mAdapters.add(this.gAb);
        this.mAdapters.add(this.gAc);
        this.mAdapters.add(this.gAd);
        this.mAdapters.add(this.gAe);
        this.mAdapters.add(this.gAf);
        this.mAdapters.add(this.gAg);
        this.mAdapters.add(this.guk);
        this.mAdapters.add(this.gAh);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gAg != null) {
            this.gAg.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gAh.setIsHost(z);
        this.gzZ.setIsHost(z);
    }
}
