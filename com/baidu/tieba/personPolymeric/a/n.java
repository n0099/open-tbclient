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
    private com.baidu.tieba.person.a.a ijF;
    private m ipW;
    private b ipX;
    private i ipY;
    private a ipZ;
    private c iqa;
    private h iqb;
    private e iqc;
    private k iqd;
    private d iqe;
    private com.baidu.tieba.person.a.d iqf;
    private p iqg;
    private BdPersonListView iqh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.iqh = bdPersonListView;
        this.ipW = new m(tbPageContext);
        this.ipX = new b(tbPageContext);
        this.ipY = new i(tbPageContext);
        this.ipZ = new a(tbPageContext);
        this.iqa = new c(tbPageContext);
        this.iqb = new h(tbPageContext, tbPageContext.getUniqueId());
        this.iqc = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.isc);
        this.iqd = new k(tbPageContext);
        this.iqe = new d(tbPageContext);
        this.iqf = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ijG);
        this.ijF = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijn);
        this.iqg = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.ipW);
        this.mAdapters.add(this.ipX);
        this.mAdapters.add(this.ipY);
        this.mAdapters.add(this.ipZ);
        this.mAdapters.add(this.iqa);
        this.mAdapters.add(this.iqb);
        this.mAdapters.add(this.iqc);
        this.mAdapters.add(this.iqd);
        this.mAdapters.add(this.iqe);
        this.mAdapters.add(this.iqf);
        this.mAdapters.add(this.ijF);
        this.mAdapters.add(this.iqg);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.iqf != null) {
            this.iqf.S(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.iqg.setIsHost(z);
        this.ipY.setIsHost(z);
    }
}
