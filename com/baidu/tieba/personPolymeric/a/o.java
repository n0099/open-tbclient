package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private com.baidu.tieba.person.a.a lBM;
    private f lJa;
    private l lJb;
    private g lJc;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.lJa = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.lLj);
        this.lJb = new l(tbPageContext);
        this.lJc = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.lLc);
        this.lBM = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lBz);
        this.bhH.add(this.lJa);
        this.bhH.add(this.lJb);
        this.bhH.add(this.lJc);
        this.bhH.add(this.lBM);
        hTypeListView.addAdapters(this.bhH);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.lJa.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.lJc.setOnClickListener(onClickListener);
    }
}
