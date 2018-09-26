package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a gaA;
    private f ggx;
    private l ggy;
    private g ggz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.ggx = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.giD);
        this.ggy = new l(tbPageContext);
        this.ggz = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.giw);
        this.gaA = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.gai);
        this.mAdapters.add(this.ggx);
        this.mAdapters.add(this.ggy);
        this.mAdapters.add(this.ggz);
        this.mAdapters.add(this.gaA);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void P(View.OnClickListener onClickListener) {
        this.ggx.setOnClickListener(onClickListener);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.ggz.setOnClickListener(onClickListener);
    }
}
