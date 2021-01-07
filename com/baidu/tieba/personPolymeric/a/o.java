package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private com.baidu.tieba.person.a.a mnN;
    private f mvh;
    private l mvi;
    private g mvj;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mvh = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mxr);
        this.mvi = new l(tbPageContext);
        this.mvj = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mxk);
        this.mnN = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mny);
        this.boM.add(this.mvh);
        this.boM.add(this.mvi);
        this.boM.add(this.mvj);
        this.boM.add(this.mnN);
        hTypeListView.addAdapters(this.boM);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mvh.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mvj.setOnClickListener(onClickListener);
    }
}
