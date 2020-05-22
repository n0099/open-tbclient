package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.e;
import com.baidu.card.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes11.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, ag<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.e> adt;
    private String aeX;
    public BdUniqueId epM;
    private int glW;
    private int kqO;
    private int kqP;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kqO = 0;
        this.kqP = 0;
        this.glW = 0;
        this.adt = new aa<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                if (view != null && eVar != null && eVar.aOi() != null) {
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
        cgg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.b(this.mPageContext);
        eVar.aY(32768);
        if (this.kqO > 0) {
            eVar.aX(this.kqO);
        }
        eVar.aC(false);
        eVar.aD(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.a.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                a.this.a(view, absThreadDataSupport);
            }
        });
        aVar.a(eVar);
        aVar.rK().be(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.c cVar = new com.baidu.card.c(this.mPageContext.getPageActivity());
        cVar.setOnCardSubClickListener(new aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                a.this.a(view, absThreadDataSupport);
            }
        });
        aVar.c(cVar);
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar2 = new com.baidu.tbadk.core.data.c();
        cVar2.dAZ = 3;
        cVar2.dBf = 3;
        ahVar.setAgreeStatisticData(cVar2);
        ahVar.setFrom(8);
        ahVar.setShareReportFrom(6);
        ahVar.bm(4);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        ae rL = aVar.rL();
        rL.setSourceForPb(4);
        ag<com.baidu.tieba.card.data.e> agVar = new ag<>(rL);
        agVar.setPageId(this.epM);
        agVar.bl(this.kqP);
        a(new x() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, oVar);
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, ag<com.baidu.tieba.card.data.e> agVar) {
        if (eVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        eVar.sr(eVar.position + 1);
        agVar.rM().setPage(this.aeX);
        if (!this.mIsHost) {
            agVar.rO();
        }
        agVar.b((ag<com.baidu.tieba.card.data.e>) eVar);
        agVar.rM().a(this.adt);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.h(eVar);
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, o oVar) {
        if ((oVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ag)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) oVar;
            eVar.objType = 1;
            au.a((AbsThreadDataSupport) eVar, view.getContext(), 4, false);
            ((ag) view.getTag()).rM().b(new a.C0097a(1));
        }
    }

    private void cgg() {
        k.gHr = "c13542";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
        if (view != null && absThreadDataSupport != null && view.getId() != -1) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 1);
            } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
                com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 3);
            }
        }
    }

    public void Br(int i) {
        this.kqO = i;
    }

    public void setTabType(int i) {
        this.glW = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Bq(int i) {
        this.kqP = i;
    }
}
