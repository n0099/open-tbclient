package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, ThreadCardViewHolder<k>> implements com.baidu.tieba.a.f {
    private ab<k> agg;
    private String aif;
    private boolean akO;
    public BdUniqueId fGZ;
    private int hXb;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mzV;
    private int mzW;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.mzV = 0;
        this.mzW = 0;
        this.hXb = 0;
        this.agg = new ab<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.bln() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fGZ);
        dVar.br(1024);
        dVar.br(32768);
        if (this.mzV > 0) {
            dVar.bq(this.mzV);
        }
        dVar.aC(false);
        dVar.aD(false);
        aVar.a(dVar);
        aVar.c(new t(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 3;
        eVar.eMg = 3;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(8);
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        ak th = aVar.th();
        th.setSourceForPb(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(th);
        threadCardViewHolder.setPageId(this.fGZ);
        threadCardViewHolder.bC(this.mzW);
        a(new w() { // from class: com.baidu.tieba.personPolymeric.a.a.d.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    k kVar = (k) nVar;
                    kVar.objType = 1;
                    if (d.this.agg != null) {
                        d.this.agg.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.tj() == null) {
            return null;
        }
        kVar.xd(kVar.position + 1);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        if (!this.mIsHost) {
            threadCardViewHolder.tl();
        }
        threadCardViewHolder.b((ThreadCardViewHolder<k>) kVar);
        threadCardViewHolder.b(this.agg);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.j(kVar);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    public void GX(int i) {
        this.mzV = i;
    }

    public void setTabType(int i) {
        this.hXb = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void GW(int i) {
        this.mzW = i;
    }
}
