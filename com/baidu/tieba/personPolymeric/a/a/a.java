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
import com.baidu.card.d;
import com.baidu.card.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, ThreadCardViewHolder<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.e> ago;
    private String air;
    public BdUniqueId fEN;
    private int hSs;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mqG;
    private int mqH;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mqG = 0;
        this.mqH = 0;
        this.hSs = 0;
        this.ago = new aa<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                if (view != null && eVar != null && eVar.bkV() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.bottom_mask) {
                        com.baidu.tieba.personPolymeric.a.a(view, eVar, 2);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, eVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.e> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fEN);
        dVar.b(this.mPageContext);
        dVar.br(32768);
        if (this.mqG > 0) {
            dVar.bq(this.mqG);
        }
        dVar.aC(false);
        dVar.aD(false);
        dVar.a(new d.a() { // from class: com.baidu.tieba.personPolymeric.a.a.a.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                a.this.a(view, aVar2);
            }
        });
        aVar.a(dVar);
        aVar.tl().bx(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.b bVar = new com.baidu.card.b(this.mPageContext.getPageActivity());
        bVar.setOnCardSubClickListener(new aa<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar2) {
                a.this.a(view, aVar2);
            }
        });
        aVar.c(bVar);
        aVar.a((com.baidu.card.h) new k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eJO = 3;
        dVar2.eJU = 3;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(8);
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        ak tk = aVar.tk();
        tk.setSourceForPb(4);
        ThreadCardViewHolder<com.baidu.tieba.card.data.e> threadCardViewHolder = new ThreadCardViewHolder<>(tk);
        threadCardViewHolder.setPageId(this.fEN);
        threadCardViewHolder.bC(this.mqH);
        a(new w() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, nVar);
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, ThreadCardViewHolder<com.baidu.tieba.card.data.e> threadCardViewHolder) {
        if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        eVar.wT(eVar.position + 1);
        threadCardViewHolder.tm().setPage(this.air);
        if (!this.mIsHost) {
            threadCardViewHolder.tp();
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.e>) eVar);
        threadCardViewHolder.tm().a(this.ago);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.j(eVar);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, n nVar) {
        if ((nVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) nVar;
            eVar.objType = 1;
            ay.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).tm().b(new a.C0089a(1));
        }
    }

    private void cNf() {
        com.baidu.tieba.card.data.k.iva = "c13542";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tbadk.core.data.a aVar) {
        if (view != null && aVar != null && view.getId() != -1) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                com.baidu.tieba.personPolymeric.a.a(view, aVar, 1);
            } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
                com.baidu.tieba.personPolymeric.a.a(view, aVar, 3);
            }
        }
    }

    public void GF(int i) {
        this.mqG = i;
    }

    public void setTabType(int i) {
        this.hSs = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void GE(int i) {
        this.mqH = i;
    }
}
