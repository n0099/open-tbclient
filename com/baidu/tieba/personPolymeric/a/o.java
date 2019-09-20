package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a ilE;
    private f ish;
    private l isi;
    private g isj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.ish = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.ium);
        this.isi = new l(tbPageContext);
        this.isj = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.iuf);
        this.ilE = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ilm);
        this.mAdapters.add(this.ish);
        this.mAdapters.add(this.isi);
        this.mAdapters.add(this.isj);
        this.mAdapters.add(this.ilE);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void W(View.OnClickListener onClickListener) {
        this.ish.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.isj.setOnClickListener(onClickListener);
    }
}
