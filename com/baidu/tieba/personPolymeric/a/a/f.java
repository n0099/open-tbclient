package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.an;
import com.baidu.card.aq;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.card.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes18.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, ak<k>> implements com.baidu.tieba.a.f {
    private aa<k> adN;
    private String afx;
    private boolean aib;
    public BdUniqueId eEU;
    private int gEw;
    private int kUT;
    private int kUU;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.kUT = 0;
        this.kUU = 0;
        this.gEw = 0;
        this.adN = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aTN() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eEU);
        eVar.bg(1024);
        eVar.bg(32768);
        if (this.kUT > 0) {
            eVar.bf(this.kUT);
        }
        eVar.aD(false);
        eVar.aE(false);
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
        ad adVar = new ad(this.mPageContext);
        adVar.b((Boolean) false);
        adVar.e(0, 0, 0, l.getDimens(this.mContext, R.dimen.tbds20));
        adVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(adVar);
        aVar.se().bm(l.getDimens(this.mContext, R.dimen.tbds25));
        final ad adVar2 = new ad(this.mPageContext);
        adVar2.b((Boolean) true);
        adVar2.e(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds31));
        adVar2.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
                    ax.a(absThreadDataSupport.aTN().dUi, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(adVar2.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) adVar2);
        final aq aqVar = new aq(this.mPageContext.getPageActivity());
        aqVar.b((Boolean) true);
        aqVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && absThreadDataSupport.aTN().dUi != null) {
                    ax.a(absThreadDataSupport.aTN().dUi, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(aqVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) aqVar);
        aVar.a((com.baidu.card.h) new an(this.mPageContext.getPageActivity()));
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(4);
        aVar.a((com.baidu.card.h) asVar);
        j jVar = new j(this.mPageContext.getPageActivity());
        jVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.h) jVar);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 3;
        cVar.dNH = 3;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(8);
        alVar.setShareReportFrom(6);
        alVar.setFromForPb(4);
        aVar.b(alVar);
        aVar.se().setBackgroundResource(R.drawable.addresslist_item_bg);
        ai sf = aVar.sf();
        sf.setSourceForPb(4);
        ak<k> akVar = new ak<>(sf);
        akVar.setPageId(this.eEU);
        akVar.bt(this.kUU);
        a(new z() { // from class: com.baidu.tieba.personPolymeric.a.a.f.5
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (f.this.adN != null) {
                        f.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 4, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ak<k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        akVar.sg().setPage(this.afx);
        if (!this.mIsHost) {
            akVar.si();
        }
        akVar.b((ak<k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.personPolymeric.a.h(kVar);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void CV(int i) {
        this.kUT = i;
    }

    public void setTabType(int i) {
        this.gEw = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void CU(int i) {
        this.kUU = i;
    }
}
