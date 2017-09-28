package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.person.a.a eZm;
    private f feZ;
    private m ffa;
    private g ffb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public p(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.feZ = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.p.fhn);
        this.ffa = new m(tbPageContext);
        this.ffb = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fhe);
        this.eZm = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.eYX);
        this.mAdapters.add(this.feZ);
        this.mAdapters.add(this.ffa);
        this.mAdapters.add(this.ffb);
        this.mAdapters.add(this.eZm);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void K(View.OnClickListener onClickListener) {
        this.feZ.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.ffb.setOnClickListener(onClickListener);
    }
}
