package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a fCI;
    private f fIp;
    private l fIq;
    private g fIr;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fIp = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.fKF);
        this.fIq = new l(tbPageContext);
        this.fIr = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fKy);
        this.fCI = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fCp);
        this.mAdapters.add(this.fIp);
        this.mAdapters.add(this.fIq);
        this.mAdapters.add(this.fIr);
        this.mAdapters.add(this.fCI);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fIp.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fIr.setOnClickListener(onClickListener);
    }
}
