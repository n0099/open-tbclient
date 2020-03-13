package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private com.baidu.tieba.person.a.a jgg;
    private f jna;
    private l jnb;
    private g jnc;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jna = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.jpm);
        this.jnb = new l(tbPageContext);
        this.jnc = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.jpf);
        this.jgg = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfT);
        this.asF.add(this.jna);
        this.asF.add(this.jnb);
        this.asF.add(this.jnc);
        this.asF.add(this.jgg);
        hTypeListView.addAdapters(this.asF);
    }

    public void W(View.OnClickListener onClickListener) {
        this.jna.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jnc.setOnClickListener(onClickListener);
    }
}
