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
    private com.baidu.tieba.person.a.a gjz;
    private m gpm;
    private b gpn;
    private i gpo;
    private a gpp;
    private c gpq;
    private h gpr;
    private e gps;
    private k gpt;
    private d gpu;
    private com.baidu.tieba.person.a.d gpv;
    private p gpw;
    private BdPersonListView gpx;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gpx = bdPersonListView;
        this.gpm = new m(tbPageContext);
        this.gpn = new b(tbPageContext);
        this.gpo = new i(tbPageContext);
        this.gpp = new a(tbPageContext);
        this.gpq = new c(tbPageContext);
        this.gpr = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gps = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.grs);
        this.gpt = new k(tbPageContext);
        this.gpu = new d(tbPageContext);
        this.gpv = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gjA);
        this.gjz = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gjh);
        this.gpw = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gpm);
        this.mAdapters.add(this.gpn);
        this.mAdapters.add(this.gpo);
        this.mAdapters.add(this.gpp);
        this.mAdapters.add(this.gpq);
        this.mAdapters.add(this.gpr);
        this.mAdapters.add(this.gps);
        this.mAdapters.add(this.gpt);
        this.mAdapters.add(this.gpu);
        this.mAdapters.add(this.gpv);
        this.mAdapters.add(this.gjz);
        this.mAdapters.add(this.gpw);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gpv != null) {
            this.gpv.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gpw.setIsHost(z);
        this.gpo.setIsHost(z);
    }
}
