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
    private com.baidu.tieba.person.a.a ilE;
    private m irV;
    private b irW;
    private i irX;
    private a irY;
    private c irZ;
    private h isa;
    private e isb;
    private k isc;
    private d isd;
    private com.baidu.tieba.person.a.d ise;
    private p isf;
    private BdPersonListView isg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.isg = bdPersonListView;
        this.irV = new m(tbPageContext);
        this.irW = new b(tbPageContext);
        this.irX = new i(tbPageContext);
        this.irY = new a(tbPageContext);
        this.irZ = new c(tbPageContext);
        this.isa = new h(tbPageContext, tbPageContext.getUniqueId());
        this.isb = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.iub);
        this.isc = new k(tbPageContext);
        this.isd = new d(tbPageContext);
        this.ise = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ilF);
        this.ilE = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ilm);
        this.isf = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.irV);
        this.mAdapters.add(this.irW);
        this.mAdapters.add(this.irX);
        this.mAdapters.add(this.irY);
        this.mAdapters.add(this.irZ);
        this.mAdapters.add(this.isa);
        this.mAdapters.add(this.isb);
        this.mAdapters.add(this.isc);
        this.mAdapters.add(this.isd);
        this.mAdapters.add(this.ise);
        this.mAdapters.add(this.ilE);
        this.mAdapters.add(this.isf);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.ise != null) {
            this.ise.S(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.isf.setIsHost(z);
        this.irX.setIsHost(z);
    }
}
