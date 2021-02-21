package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private com.baidu.tieba.person.a.a msA;
    private f mzR;
    private l mzS;
    private g mzT;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mzR = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mCc);
        this.mzS = new l(tbPageContext);
        this.mzT = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mBV);
        this.msA = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.msl);
        this.bns.add(this.mzR);
        this.bns.add(this.mzS);
        this.bns.add(this.mzT);
        this.bns.add(this.msA);
        hTypeListView.addAdapters(this.bns);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mzR.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mzT.setOnClickListener(onClickListener);
    }
}
