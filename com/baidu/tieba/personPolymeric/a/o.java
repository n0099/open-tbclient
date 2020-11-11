package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private com.baidu.tieba.person.a.a lUf;
    private f mbv;
    private l mbw;
    private g mbx;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mbv = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.mdE);
        this.mbw = new l(tbPageContext);
        this.mbx = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.mdx);
        this.lUf = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lTS);
        this.bky.add(this.mbv);
        this.bky.add(this.mbw);
        this.bky.add(this.mbx);
        this.bky.add(this.lUf);
        hTypeListView.addAdapters(this.bky);
    }

    public void aa(View.OnClickListener onClickListener) {
        this.mbv.setOnClickListener(onClickListener);
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mbx.setOnClickListener(onClickListener);
    }
}
