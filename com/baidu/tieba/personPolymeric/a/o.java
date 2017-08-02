package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.personCenter.a.b fcZ;
    private f fhm;
    private l fhn;
    private g fho;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fhm = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.n.fjr);
        this.fhn = new l(tbPageContext);
        this.fho = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fjj);
        this.fcZ = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.fcH);
        this.mAdapters.add(this.fhm);
        this.mAdapters.add(this.fhn);
        this.mAdapters.add(this.fho);
        this.mAdapters.add(this.fcZ);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fhm.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fho.setOnClickListener(onClickListener);
    }
}
