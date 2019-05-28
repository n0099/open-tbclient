package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o {
    private com.baidu.tieba.person.a.a ick;
    private f iiL;
    private l iiM;
    private g iiN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.iiL = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.ikQ);
        this.iiM = new l(tbPageContext);
        this.iiN = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.ikJ);
        this.ick = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ibS);
        this.mAdapters.add(this.iiL);
        this.mAdapters.add(this.iiM);
        this.mAdapters.add(this.iiN);
        this.mAdapters.add(this.ick);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void U(View.OnClickListener onClickListener) {
        this.iiL.setOnClickListener(onClickListener);
    }

    public void V(View.OnClickListener onClickListener) {
        this.iiN.setOnClickListener(onClickListener);
    }
}
