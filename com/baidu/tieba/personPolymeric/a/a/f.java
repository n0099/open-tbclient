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
import com.baidu.card.al;
import com.baidu.card.b;
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
public class f extends com.baidu.adp.widget.ListView.a<k, ag<k>> implements com.baidu.tieba.a.f {
    private aa<k> adt;
    private String aeX;
    private boolean aha;
    public BdUniqueId epM;
    private int glW;
    private int kqO;
    private int kqP;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.kqO = 0;
        this.kqP = 0;
        this.glW = 0;
        this.adt = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aOi() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<k> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aY(1024);
        eVar.aY(32768);
        if (this.kqO > 0) {
            eVar.aX(this.kqO);
        }
        eVar.aC(false);
        eVar.aD(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (view != null && absThreadDataSupport != null) {
                    int id = view.getId();
                    if (id == R.id.user_name || id == R.id.user_avatar) {
                        com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 1);
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext);
        aaVar.b((Boolean) false);
        aaVar.e(0, 0, 0, l.getDimens(this.mContext, R.dimen.tbds20));
        aaVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(aaVar);
        aVar.rK().be(l.getDimens(this.mContext, R.dimen.tbds25));
        final com.baidu.card.aa aaVar2 = new com.baidu.card.aa(this.mPageContext);
        aaVar2.b((Boolean) true);
        aaVar2.e(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39));
        aaVar2.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(aaVar2.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) aaVar2);
        final al alVar = new al(this.mPageContext.getPageActivity());
        alVar.b((Boolean) true);
        alVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(alVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) alVar);
        j jVar = new j(this.mPageContext.getPageActivity());
        jVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.h) jVar);
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 3;
        cVar.dBf = 3;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(8);
        ahVar.setShareReportFrom(6);
        ahVar.bm(4);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        ae rL = aVar.rL();
        rL.setSourceForPb(4);
        ag<k> agVar = new ag<>(rL);
        agVar.setPageId(this.epM);
        agVar.bl(this.kqP);
        a(new x() { // from class: com.baidu.tieba.personPolymeric.a.a.f.5
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof k) && (view.getTag() instanceof ag)) {
                    ag agVar2 = (ag) view.getTag();
                    k kVar = (k) oVar;
                    kVar.objType = 1;
                    if (f.this.adt != null) {
                        f.this.adt.a(agVar2.getView(), kVar);
                    }
                    au.a((AbsThreadDataSupport) kVar, view.getContext(), 4, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ag<k> agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.sr(kVar.position + 1);
        agVar.rM().setPage(this.aeX);
        if (!this.mIsHost) {
            agVar.rO();
        }
        agVar.b((ag<k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.personPolymeric.a.h(kVar);
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
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
