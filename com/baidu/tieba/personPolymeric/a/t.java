package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private h eCc;
    private q eCd;
    private i eCe;
    private com.baidu.tieba.personCenter.a.b exS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public t(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.eCc = new h(tbPageContext, com.baidu.tieba.personPolymeric.c.m.eDt);
        this.eCd = new q(tbPageContext);
        this.eCe = new i(tbPageContext, com.baidu.tieba.personPolymeric.c.g.eDl);
        this.exS = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.b.b.eyF);
        this.mAdapters.add(this.eCc);
        this.mAdapters.add(this.eCd);
        this.mAdapters.add(this.eCe);
        this.mAdapters.add(this.exS);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        this.eCc.setOnClickListener(onClickListener);
    }

    public void O(View.OnClickListener onClickListener) {
        this.eCe.setOnClickListener(onClickListener);
    }
}
