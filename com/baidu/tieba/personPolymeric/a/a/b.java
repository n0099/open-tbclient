package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.widget.ListView.a<k, ThreadCardViewHolder<k>> implements com.baidu.tieba.a.f {
    private ab<k> ahy;
    private String ajx;
    private boolean amh;
    public BdUniqueId fIy;
    private int hYK;
    private int mBY;
    private int mBZ;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amh = true;
        this.mBY = 0;
        this.mBZ = 0;
        this.hYK = 0;
        this.ahy = new ab<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.b.1
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
        af afVar = new af(this.mPageContext);
        afVar.c(false);
        afVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(afVar);
        aVar.ti().by(l.getDimens(this.mContext, R.dimen.tbds25));
        final af afVar2 = new af(this.mPageContext);
        afVar2.c(true);
        afVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar2.e(com.baidu.tbadk.a.b.b.bjN(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.b.bjN(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new a.InterfaceC0094a() { // from class: com.baidu.tieba.personPolymeric.a.a.b.2
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.blp() != null && aVar2.blp().eUD != null) {
                    az.a(aVar2.blp().eUD, b.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(afVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) afVar2);
        final an anVar = new an(this.mPageContext.getPageActivity());
        anVar.c(true);
        anVar.a(new a.InterfaceC0094a() { // from class: com.baidu.tieba.personPolymeric.a.a.b.3
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.blp() != null && aVar2.blp().eUD != null) {
                    az.a(aVar2.blp().eUD, b.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(anVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) anVar);
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
        a(new w() { // from class: com.baidu.tieba.personPolymeric.a.a.b.4
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    k kVar = (k) nVar;
                    kVar.objType = 1;
                    if (b.this.ahy != null) {
                        b.this.ahy.a(threadCardViewHolder2.getView(), kVar);
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
