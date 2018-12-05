package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gqp;
    private f gwo;
    private l gwp;
    private g gwq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gwo = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gyt);
        this.gwp = new l(tbPageContext);
        this.gwq = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gym);
        this.gqp = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gpX);
        this.mAdapters.add(this.gwo);
        this.mAdapters.add(this.gwp);
        this.mAdapters.add(this.gwq);
        this.mAdapters.add(this.gqp);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.gwo.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gwq.setOnClickListener(onClickListener);
    }
}
