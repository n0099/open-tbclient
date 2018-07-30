package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a fTs;
    private f fZg;
    private l fZh;
    private g fZi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fZg = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gbl);
        this.fZh = new l(tbPageContext);
        this.fZi = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gbe);
        this.fTs = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fTa);
        this.mAdapters.add(this.fZg);
        this.mAdapters.add(this.fZh);
        this.mAdapters.add(this.fZi);
        this.mAdapters.add(this.fTs);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.fZg.setOnClickListener(onClickListener);
    }

    public void R(View.OnClickListener onClickListener) {
        this.fZi.setOnClickListener(onClickListener);
    }
}
