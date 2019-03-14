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
    private com.baidu.tieba.person.a.a hKv;
    private m hPX;
    private b hPY;
    private i hPZ;
    private a hQa;
    private c hQb;
    private h hQc;
    private e hQd;
    private k hQe;
    private d hQf;
    private com.baidu.tieba.person.a.d hQg;
    private p hQh;
    private BdPersonListView hQi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.hQi = bdPersonListView;
        this.hPX = new m(tbPageContext);
        this.hPY = new b(tbPageContext);
        this.hPZ = new i(tbPageContext);
        this.hQa = new a(tbPageContext);
        this.hQb = new c(tbPageContext);
        this.hQc = new h(tbPageContext, tbPageContext.getUniqueId());
        this.hQd = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.hSd);
        this.hQe = new k(tbPageContext);
        this.hQf = new d(tbPageContext);
        this.hQg = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.hKw);
        this.hKv = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.hKd);
        this.hQh = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.hPX);
        this.mAdapters.add(this.hPY);
        this.mAdapters.add(this.hPZ);
        this.mAdapters.add(this.hQa);
        this.mAdapters.add(this.hQb);
        this.mAdapters.add(this.hQc);
        this.mAdapters.add(this.hQd);
        this.mAdapters.add(this.hQe);
        this.mAdapters.add(this.hQf);
        this.mAdapters.add(this.hQg);
        this.mAdapters.add(this.hKv);
        this.mAdapters.add(this.hQh);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.hQg != null) {
            this.hQg.O(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.hQh.setIsHost(z);
        this.hPZ.setIsHost(z);
    }
}
