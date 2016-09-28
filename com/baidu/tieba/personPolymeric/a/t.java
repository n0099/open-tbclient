package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private List<com.baidu.adp.widget.ListView.a> bOo = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eDN;
    private i eDV;
    private h eJk;
    private q eJl;

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eJk = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eKu);
        this.eJl = new q(tbPageContext);
        this.eDV = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eKm);
        this.eDN = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eFB);
        this.bOo.add(this.eJk);
        this.bOo.add(this.eJl);
        this.bOo.add(this.eDV);
        this.bOo.add(this.eDN);
        hTypeListView.g(this.bOo);
    }

    public void M(View.OnClickListener onClickListener) {
        this.eJk.setOnClickListener(onClickListener);
    }

    public void J(View.OnClickListener onClickListener) {
        this.eDV.setOnClickListener(onClickListener);
    }
}
