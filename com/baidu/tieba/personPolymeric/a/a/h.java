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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes8.dex */
public class h extends com.baidu.adp.widget.ListView.a<k, ThreadCardViewHolder<k>> implements com.baidu.tieba.a.f {
    private aa<k> ahf;
    private String aji;
    private boolean alQ;
    public BdUniqueId fJu;
    private int hWZ;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mvm;
    private int mvn;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alQ = true;
        this.mvm = 0;
        this.mvn = 0;
        this.hWZ = 0;
        this.ahf = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.boO() != null && view.getId() == R.id.forum_name_text) {
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
        dVar.setPageUniqueId(this.fJu);
        dVar.bt(1024);
        dVar.bt(32768);
        if (this.mvm > 0) {
            dVar.bs(this.mvm);
        }
        dVar.aC(false);
        dVar.aD(false);
        aVar.a(dVar);
        ap apVar = new ap(this.mPageContext.getPageActivity());
        aVar.c(apVar);
        aVar.tx().bz(l.getDimens(this.mContext, R.dimen.tbds25));
        apVar.bF(2);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(4);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eOz = 3;
        dVar2.eOF = 3;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(8);
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        ak tw = aVar.tw();
        tw.setSourceForPb(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(tw);
        threadCardViewHolder.setPageId(this.fJu);
        threadCardViewHolder.bE(this.mvn);
        a(new w() { // from class: com.baidu.tieba.personPolymeric.a.a.h.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    k kVar = (k) nVar;
                    kVar.objType = 1;
                    if (h.this.ahf != null) {
                        h.this.ahf.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        threadCardViewHolder.ty().setPage(this.aji);
        if (!this.mIsHost) {
            threadCardViewHolder.tA();
        }
        threadCardViewHolder.b((ThreadCardViewHolder<k>) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        com.baidu.tieba.personPolymeric.a.j(kVar);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    public void Im(int i) {
        this.mvm = i;
    }

    public void setTabType(int i) {
        this.hWZ = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Il(int i) {
        this.mvn = i;
    }
}
