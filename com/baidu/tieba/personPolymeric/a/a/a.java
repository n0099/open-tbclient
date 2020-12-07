package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.card.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes24.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, am<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.e> agG;
    private String aiw;
    public BdUniqueId fzO;
    private int hKL;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mpX;
    private int mpY;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mpX = 0;
        this.mpY = 0;
        this.hKL = 0;
        this.agG = new ab<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                if (view != null && eVar != null && eVar.bmn() != null) {
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
        cNP();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.e> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.b(this.mPageContext);
        eVar.bt(32768);
        if (this.mpX > 0) {
            eVar.bs(this.mpX);
        }
        eVar.aD(false);
        eVar.aE(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.a.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                a.this.a(view, aVar2);
            }
        });
        aVar.a(eVar);
        aVar.tY().bz(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.c cVar = new com.baidu.card.c(this.mPageContext.getPageActivity());
        cVar.setOnCardSubClickListener(new ab<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar2) {
                a.this.a(view, aVar2);
            }
        });
        aVar.c(cVar);
        aVar.a((com.baidu.card.i) new k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 3;
        dVar.eEP = 3;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(8);
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        ak tX = aVar.tX();
        tX.setSourceForPb(4);
        am<com.baidu.tieba.card.data.e> amVar = new am<>(tX);
        amVar.setPageId(this.fzO);
        amVar.bE(this.mpY);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, am<com.baidu.tieba.card.data.e> amVar) {
        if (eVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        eVar.ym(eVar.position + 1);
        amVar.tZ().setPage(this.aiw);
        if (!this.mIsHost) {
            amVar.ub();
        }
        amVar.b((am<com.baidu.tieba.card.data.e>) eVar);
        amVar.tZ().a(this.agG);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.j(eVar);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof am)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 4, false);
            ((am) view.getTag()).tZ().b(new a.C0097a(1));
        }
    }

    private void cNP() {
        com.baidu.tieba.card.data.k.ink = "c13542";
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

    public void Is(int i) {
        this.mpX = i;
    }

    public void setTabType(int i) {
        this.hKL = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Ir(int i) {
        this.mpY = i;
    }
}
