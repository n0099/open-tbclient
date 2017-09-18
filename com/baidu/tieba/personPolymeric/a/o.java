package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.personCenter.a.b ffp;
    private f fjH;
    private l fjI;
    private g fjJ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fjH = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.n.flM);
        this.fjI = new l(tbPageContext);
        this.fjJ = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.flE);
        this.ffp = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.feY);
        this.mAdapters.add(this.fjH);
        this.mAdapters.add(this.fjI);
        this.mAdapters.add(this.fjJ);
        this.mAdapters.add(this.ffp);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void I(View.OnClickListener onClickListener) {
        this.fjH.setOnClickListener(onClickListener);
    }

    public void J(View.OnClickListener onClickListener) {
        this.fjJ.setOnClickListener(onClickListener);
    }
}
