package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tieba.personCenter.a.b fge;
    private f fkt;
    private l fku;
    private g fkv;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.fkt = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.n.fmw);
        this.fku = new l(tbPageContext);
        this.fkv = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.fmo);
        this.fge = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.ffM);
        this.mAdapters.add(this.fkt);
        this.mAdapters.add(this.fku);
        this.mAdapters.add(this.fkv);
        this.mAdapters.add(this.fge);
        hTypeListView.addAdapters(this.mAdapters);
    }

    public void O(View.OnClickListener onClickListener) {
        this.fkt.setOnClickListener(onClickListener);
    }

    public void P(View.OnClickListener onClickListener) {
        this.fkv.setOnClickListener(onClickListener);
    }
}
