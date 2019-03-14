package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a hKv;
    private f hQj;
    private l hQk;
    private g hQl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.hQj = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.hSo);
        this.hQk = new l(tbPageContext);
        this.hQl = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.hSh);
        this.hKv = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.hKd);
        this.mAdapters.add(this.hQj);
        this.mAdapters.add(this.hQk);
        this.mAdapters.add(this.hQl);
        this.mAdapters.add(this.hKv);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.hQj.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.hQl.setOnClickListener(onClickListener);
    }
}
