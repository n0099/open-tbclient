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
    private com.baidu.tieba.person.a.a fTs;
    private m fYU;
    private b fYV;
    private i fYW;
    private a fYX;
    private c fYY;
    private h fYZ;
    private e fZa;
    private k fZb;
    private d fZc;
    private com.baidu.tieba.person.a.d fZd;
    private p fZe;
    private BdPersonListView fZf;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fZf = bdPersonListView;
        this.fYU = new m(tbPageContext);
        this.fYV = new b(tbPageContext);
        this.fYW = new i(tbPageContext);
        this.fYX = new a(tbPageContext);
        this.fYY = new c(tbPageContext);
        this.fYZ = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fZa = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gba);
        this.fZb = new k(tbPageContext);
        this.fZc = new d(tbPageContext);
        this.fZd = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fTt);
        this.fTs = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fTa);
        this.fZe = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fYU);
        this.mAdapters.add(this.fYV);
        this.mAdapters.add(this.fYW);
        this.mAdapters.add(this.fYX);
        this.mAdapters.add(this.fYY);
        this.mAdapters.add(this.fYZ);
        this.mAdapters.add(this.fZa);
        this.mAdapters.add(this.fZb);
        this.mAdapters.add(this.fZc);
        this.mAdapters.add(this.fZd);
        this.mAdapters.add(this.fTs);
        this.mAdapters.add(this.fZe);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.fZd != null) {
            this.fZd.N(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fZe.setIsHost(z);
        this.fYW.setIsHost(z);
    }
}
