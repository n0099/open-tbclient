package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private com.baidu.tieba.person.a.a msl;
    private f mzC;
    private l mzD;
    private g mzE;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mzC = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mBN);
        this.mzD = new l(tbPageContext);
        this.mzE = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mBG);
        this.msl = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mrV);
        this.bns.add(this.mzC);
        this.bns.add(this.mzD);
        this.bns.add(this.mzE);
        this.bns.add(this.msl);
        hTypeListView.addAdapters(this.bns);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mzC.setOnClickListener(onClickListener);
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mzE.setOnClickListener(onClickListener);
    }
}
