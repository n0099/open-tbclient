package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.personCenter.a.b fgg;
    private f fkv;
    private l fkw;
    private g fkx;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fkv = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.n.fmy);
        this.fkw = new l(tbPageContext);
        this.fkx = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fmq);
        this.fgg = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.ffO);
        this.mAdapters.add(this.fkv);
        this.mAdapters.add(this.fkw);
        this.mAdapters.add(this.fkx);
        this.mAdapters.add(this.fgg);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void K(View.OnClickListener onClickListener) {
        this.fkv.setOnClickListener(onClickListener);
    }

    public void L(View.OnClickListener onClickListener) {
        this.fkx.setOnClickListener(onClickListener);
    }
}
