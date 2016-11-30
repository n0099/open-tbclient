package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private List<com.baidu.adp.widget.ListView.a> bRh = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eKm;
    private i eKu;
    private h ePJ;
    private q ePK;

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.ePJ = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eQS);
        this.ePK = new q(tbPageContext);
        this.eKu = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eQK);
        this.eKm = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eMa);
        this.bRh.add(this.ePJ);
        this.bRh.add(this.ePK);
        this.bRh.add(this.eKu);
        this.bRh.add(this.eKm);
        hTypeListView.g(this.bRh);
    }

    public void O(View.OnClickListener onClickListener) {
        this.ePJ.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.eKu.setOnClickListener(onClickListener);
    }
}
