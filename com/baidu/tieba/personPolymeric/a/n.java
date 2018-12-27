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
    private com.baidu.tieba.person.a.a gtg;
    private m gyT;
    private b gyU;
    private i gyV;
    private a gyW;
    private c gyX;
    private h gyY;
    private e gyZ;
    private k gza;
    private d gzb;
    private com.baidu.tieba.person.a.d gzc;
    private p gzd;
    private BdPersonListView gze;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.gze = bdPersonListView;
        this.gyT = new m(tbPageContext);
        this.gyU = new b(tbPageContext);
        this.gyV = new i(tbPageContext);
        this.gyW = new a(tbPageContext);
        this.gyX = new c(tbPageContext);
        this.gyY = new h(tbPageContext, tbPageContext.getUniqueId());
        this.gyZ = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.gAZ);
        this.gza = new k(tbPageContext);
        this.gzb = new d(tbPageContext);
        this.gzc = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.gth);
        this.gtg = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gsO);
        this.gzd = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.gyT);
        this.mAdapters.add(this.gyU);
        this.mAdapters.add(this.gyV);
        this.mAdapters.add(this.gyW);
        this.mAdapters.add(this.gyX);
        this.mAdapters.add(this.gyY);
        this.mAdapters.add(this.gyZ);
        this.mAdapters.add(this.gza);
        this.mAdapters.add(this.gzb);
        this.mAdapters.add(this.gzc);
        this.mAdapters.add(this.gtg);
        this.mAdapters.add(this.gzd);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gzc != null) {
            this.gzc.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.gzd.setIsHost(z);
        this.gyV.setIsHost(z);
    }
}
