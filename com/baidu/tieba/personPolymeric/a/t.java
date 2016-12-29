package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private List<com.baidu.adp.widget.ListView.a> bbV = new ArrayList();
    private com.baidu.tieba.personCenter.a.b eoc;
    private h etg;
    private q eth;
    private i eti;

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.etg = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eus);
        this.eth = new q(tbPageContext);
        this.eti = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.euj);
        this.eoc = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.epy);
        this.bbV.add(this.etg);
        this.bbV.add(this.eth);
        this.bbV.add(this.eti);
        this.bbV.add(this.eoc);
        hTypeListView.g(this.bbV);
    }

    public void K(View.OnClickListener onClickListener) {
        this.etg.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.eti.setOnClickListener(onClickListener);
    }
}
