package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private com.baidu.tieba.person.a.a jRR;
    private f jYR;
    private l jYS;
    private g jYT;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jYR = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.kbe);
        this.jYS = new l(tbPageContext);
        this.jYT = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.kaX);
        this.jRR = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jRE);
        this.aMj.add(this.jYR);
        this.aMj.add(this.jYS);
        this.aMj.add(this.jYT);
        this.aMj.add(this.jRR);
        hTypeListView.addAdapters(this.aMj);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jYR.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.jYT.setOnClickListener(onClickListener);
    }
}
