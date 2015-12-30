package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.a.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private BdTypeListView dnW;
    private d dqA;
    private f dqB;
    private List<com.baidu.adp.widget.ListView.a> dqv = new ArrayList();
    private b dqw;
    private a dqx;
    private h dqy;
    private i dqz;
    private TbPageContext<?> mPageContext;

    public j(Context context, BdTypeListView bdTypeListView) {
        this.dnW = bdTypeListView;
        this.mPageContext = (TbPageContext) l.C(context);
        aM(context);
        bdTypeListView.g(this.dqv);
    }

    private void aM(Context context) {
        this.dqw = new b(this.mPageContext);
        this.dqx = new a(this.mPageContext);
        this.dqy = new h(this.mPageContext);
        this.dqz = new i(this.mPageContext);
        this.dqA = new d(this.mPageContext, n.aPP);
        this.dqB = new f(this.mPageContext, p.aQu);
        this.dqv.add(this.dqw);
        this.dqv.add(this.dqx);
        this.dqv.add(this.dqy);
        this.dqv.add(this.dqz);
        this.dqv.add(this.dqB);
        this.dqv.add(this.dqA);
        this.dqv.add(new c(this.mPageContext, o.aPP));
    }

    public void b(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dqA.a(fVar);
        this.dqB.a(fVar);
    }

    public void bJ(List<u> list) {
        this.dnW.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dqw.onChangeSkinType(i);
        this.dqx.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.dnW != null && (this.dnW.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.dnW.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dqA != null) {
            this.dqA.setFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqA != null) {
            this.dqA.setPageUniqueId(bdUniqueId);
        }
        if (this.dqB != null) {
            this.dqB.setPageUniqueId(bdUniqueId);
        }
        if (this.dqw != null) {
            this.dqw.setPageUniqueId(bdUniqueId);
        }
        if (this.dqx != null) {
            this.dqx.setPageUniqueId(bdUniqueId);
        }
    }
}
