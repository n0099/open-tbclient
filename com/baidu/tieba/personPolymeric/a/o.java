package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private com.baidu.tieba.person.a.a lOj;
    private f lVw;
    private l lVx;
    private g lVy;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.lVw = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.lXF);
        this.lVx = new l(tbPageContext);
        this.lVy = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.lXy);
        this.lOj = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lNW);
        this.bje.add(this.lVw);
        this.bje.add(this.lVx);
        this.bje.add(this.lVy);
        this.bje.add(this.lOj);
        hTypeListView.addAdapters(this.bje);
    }

    public void Z(View.OnClickListener onClickListener) {
        this.lVw.setOnClickListener(onClickListener);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.lVy.setOnClickListener(onClickListener);
    }
}
