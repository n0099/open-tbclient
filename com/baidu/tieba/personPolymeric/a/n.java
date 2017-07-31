package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private com.baidu.tieba.personCenter.a.b fel;
    private m fin;
    private b fio;
    private i fip;
    private a fiq;
    private c fir;
    private h fis;
    private j fit;
    private e fiu;
    private k fiv;
    private d fiw;
    private com.baidu.tieba.person.a.c fiy;
    private p fiz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fin = new m(tbPageContext);
        this.fio = new b(tbPageContext);
        this.fip = new i(tbPageContext);
        this.fiq = new a(tbPageContext);
        this.fir = new c(tbPageContext);
        this.fis = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fit = new j(tbPageContext);
        this.fiu = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fkr);
        this.fiv = new k(tbPageContext);
        this.fiw = new d(tbPageContext);
        this.fiy = new com.baidu.tieba.person.a.c(tbPageContext, com.baidu.tieba.person.a.e.fem);
        this.fel = new com.baidu.tieba.personCenter.a.b(tbPageContext.getPageActivity(), com.baidu.tieba.person.h.fdT);
        this.fiz = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fin);
        this.mAdapters.add(this.fio);
        this.mAdapters.add(this.fip);
        this.mAdapters.add(this.fiq);
        this.mAdapters.add(this.fir);
        this.mAdapters.add(this.fis);
        this.mAdapters.add(this.fit);
        this.mAdapters.add(this.fiu);
        this.mAdapters.add(this.fiv);
        this.mAdapters.add(this.fiw);
        this.mAdapters.add(this.fiy);
        this.mAdapters.add(this.fel);
        this.mAdapters.add(this.fiz);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fiy != null) {
            this.fiy.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fiz.setIsHost(z);
        this.fip.setIsHost(z);
    }
}
