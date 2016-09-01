package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private List<com.baidu.adp.widget.ListView.a> bOr = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eBK;
    private i eBS;
    private h eHg;
    private q eHh;

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eHg = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eIq);
        this.eHh = new q(tbPageContext);
        this.eBS = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eIi);
        this.eBK = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDy);
        this.bOr.add(this.eHg);
        this.bOr.add(this.eHh);
        this.bOr.add(this.eBS);
        this.bOr.add(this.eBK);
        hTypeListView.g(this.bOr);
    }

    public void N(View.OnClickListener onClickListener) {
        this.eHg.setOnClickListener(onClickListener);
    }

    public void K(View.OnClickListener onClickListener) {
        this.eBS.setOnClickListener(onClickListener);
    }
}
