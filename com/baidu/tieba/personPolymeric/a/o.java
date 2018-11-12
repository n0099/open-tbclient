package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gjz;
    private g gpA;
    private f gpy;
    private l gpz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.gpy = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.grD);
        this.gpz = new l(tbPageContext);
        this.gpA = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.grw);
        this.gjz = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gjh);
        this.mAdapters.add(this.gpy);
        this.mAdapters.add(this.gpz);
        this.mAdapters.add(this.gpA);
        this.mAdapters.add(this.gjz);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void R(View.OnClickListener onClickListener) {
        this.gpy.setOnClickListener(onClickListener);
    }

    public void S(View.OnClickListener onClickListener) {
        this.gpA.setOnClickListener(onClickListener);
    }
}
