package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private com.baidu.tieba.person.a.a mnO;
    private f mvi;
    private l mvj;
    private g mvk;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mvi = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mxs);
        this.mvj = new l(tbPageContext);
        this.mvk = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mxl);
        this.mnO = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mnz);
        this.boM.add(this.mvi);
        this.boM.add(this.mvj);
        this.boM.add(this.mvk);
        this.boM.add(this.mnO);
        hTypeListView.addAdapters(this.boM);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mvi.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mvk.setOnClickListener(onClickListener);
    }
}
