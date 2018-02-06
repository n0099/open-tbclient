package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gig;
    private f gnM;
    private l gnN;
    private g gnO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gnM = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gpY);
        this.gnN = new l(tbPageContext);
        this.gnO = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gpR);
        this.gig = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ghO);
        this.mAdapters.add(this.gnM);
        this.mAdapters.add(this.gnN);
        this.mAdapters.add(this.gnO);
        this.mAdapters.add(this.gig);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        this.gnM.setOnClickListener(onClickListener);
    }

    public void O(View.OnClickListener onClickListener) {
        this.gnO.setOnClickListener(onClickListener);
    }
}
