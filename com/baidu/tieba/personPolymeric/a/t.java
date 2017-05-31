package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.personCenter.a.b eGK;
    private h eKO;
    private q eKP;
    private i eKQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eKO = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.n.eMG);
        this.eKP = new q(tbPageContext);
        this.eKQ = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.h.eMy);
        this.eGK = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.eGy);
        this.mAdapters.add(this.eKO);
        this.mAdapters.add(this.eKP);
        this.mAdapters.add(this.eKQ);
        this.mAdapters.add(this.eGK);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void P(View.OnClickListener onClickListener) {
        this.eKO.setOnClickListener(onClickListener);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.eKQ.setOnClickListener(onClickListener);
    }
}
