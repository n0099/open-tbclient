package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private com.baidu.tieba.person.a.a jeW;
    private f jlS;
    private l jlT;
    private g jlU;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.jlS = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.jof);
        this.jlT = new l(tbPageContext);
        this.jlU = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.jnX);
        this.jeW = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jeJ);
        this.apl.add(this.jlS);
        this.apl.add(this.jlT);
        this.apl.add(this.jlU);
        this.apl.add(this.jeW);
        hTypeListView.addAdapters(this.apl);
    }

    public void W(View.OnClickListener onClickListener) {
        this.jlS.setOnClickListener(onClickListener);
    }

    public void X(View.OnClickListener onClickListener) {
        this.jlU.setOnClickListener(onClickListener);
    }
}
