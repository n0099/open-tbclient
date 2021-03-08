package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.ap;
import com.baidu.card.at;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
/* loaded from: classes7.dex */
public class h extends com.baidu.adp.widget.ListView.a<k, ThreadCardViewHolder<k>> implements com.baidu.tieba.a.f {
    private ab<k> ahy;
    private String ajx;
    private boolean amh;
    public BdUniqueId fIy;
    private int hYK;
    private int mBY;
    private int mBZ;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amh = true;
        this.mBY = 0;
        this.mBZ = 0;
        this.hYK = 0;
        this.ahy = new ab<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.blp() != null && view.getId() == R.id.forum_name_text) {
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
        dVar.setPageUniqueId(this.fIy);
        dVar.bs(1024);
        dVar.bs(32768);
        if (this.mBY > 0) {
            dVar.br(this.mBY);
        }
        dVar.aC(false);
        dVar.aD(false);
        aVar.a(dVar);
        ap apVar = new ap(this.mPageContext.getPageActivity());
        aVar.c(apVar);
        aVar.ti().by(l.getDimens(this.mContext, R.dimen.tbds25));
        apVar.bE(2);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(4);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 3;
        eVar.eNH = 3;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(8);
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        ak th = aVar.th();
        th.setSourceForPb(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(th);
        threadCardViewHolder.setPageId(this.fIy);
        threadCardViewHolder.bD(this.mBZ);
        a(new w() { // from class: com.baidu.tieba.personPolymeric.a.a.h.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    k kVar = (k) nVar;
                    kVar.objType = 1;
                    if (h.this.ahy != null) {
                        h.this.ahy.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eLr == null) {
            return null;
        }
        kVar.xe(kVar.position + 1);
        threadCardViewHolder.tj().setPage(this.ajx);
        if (!this.mIsHost) {
            threadCardViewHolder.tl();
        }
        threadCardViewHolder.b((ThreadCardViewHolder<k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.ahy);
        com.baidu.tieba.personPolymeric.a.j(kVar);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void Ha(int i) {
        this.mBY = i;
    }

    public void setTabType(int i) {
        this.hYK = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void GZ(int i) {
        this.mBZ = i;
    }
}
