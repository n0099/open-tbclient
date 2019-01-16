package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private f gAj;
    private l gAk;
    private g gAl;
    private com.baidu.tieba.person.a.a guk;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gAj = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gCo);
        this.gAk = new l(tbPageContext);
        this.gAl = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gCh);
        this.guk = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gtS);
        this.mAdapters.add(this.gAj);
        this.mAdapters.add(this.gAk);
        this.mAdapters.add(this.gAl);
        this.mAdapters.add(this.guk);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.gAj.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gAl.setOnClickListener(onClickListener);
    }
}
