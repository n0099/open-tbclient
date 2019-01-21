package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private f gAk;
    private l gAl;
    private g gAm;
    private com.baidu.tieba.person.a.a gul;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gAk = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.gCp);
        this.gAl = new l(tbPageContext);
        this.gAm = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.gCi);
        this.gul = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gtT);
        this.mAdapters.add(this.gAk);
        this.mAdapters.add(this.gAl);
        this.mAdapters.add(this.gAm);
        this.mAdapters.add(this.gul);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.gAk.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gAm.setOnClickListener(onClickListener);
    }
}
