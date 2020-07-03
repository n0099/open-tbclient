package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class o {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private com.baidu.tieba.person.a.a kEC;
    private f kLN;
    private l kLO;
    private g kLP;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.kLN = new f(tbPageContext, com.baidu.tieba.personPolymeric.c.o.kNZ);
        this.kLO = new l(tbPageContext);
        this.kLP = new g(tbPageContext, com.baidu.tieba.personPolymeric.c.h.kNS);
        this.kEC = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kEp);
        this.aUP.add(this.kLN);
        this.aUP.add(this.kLO);
        this.aUP.add(this.kLP);
        this.aUP.add(this.kEC);
        hTypeListView.addAdapters(this.aUP);
    }

    public void X(View.OnClickListener onClickListener) {
        this.kLN.setOnClickListener(onClickListener);
    }

    public void Y(View.OnClickListener onClickListener) {
        this.kLP.setOnClickListener(onClickListener);
    }
}
