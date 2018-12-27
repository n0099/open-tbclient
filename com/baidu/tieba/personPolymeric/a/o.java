package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gtg;
    private f gzf;
    private l gzg;
    private g gzh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gzf = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gBk);
        this.gzg = new l(tbPageContext);
        this.gzh = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gBd);
        this.gtg = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gsO);
        this.mAdapters.add(this.gzf);
        this.mAdapters.add(this.gzg);
        this.mAdapters.add(this.gzh);
        this.mAdapters.add(this.gtg);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.gzf.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gzh.setOnClickListener(onClickListener);
    }
}
