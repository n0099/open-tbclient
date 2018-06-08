package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.tieba.person.a.a fPf;
    private f fUN;
    private l fUO;
    private g fUP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fUN = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.fWU);
        this.fUO = new l(tbPageContext);
        this.fUP = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fWN);
        this.fPf = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fOM);
        this.mAdapters.add(this.fUN);
        this.mAdapters.add(this.fUO);
        this.mAdapters.add(this.fUP);
        this.mAdapters.add(this.fPf);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fUN.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fUP.setOnClickListener(onClickListener);
    }
}
