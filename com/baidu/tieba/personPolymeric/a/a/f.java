package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ap;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.card.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
/* loaded from: classes23.dex */
public class f extends com.baidu.adp.widget.ListView.a<l, am<l>> implements com.baidu.tieba.a.f {
    private aa<l> afn;
    private String ahc;
    private boolean ajR;
    public BdUniqueId eSq;
    private int gUI;
    private int ltS;
    private int ltT;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajR = true;
        this.ltS = 0;
        this.ltT = 0;
        this.gUI = 0;
        this.afn = new aa<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bcY() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, lVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eSq);
        eVar.bp(1024);
        eVar.bp(32768);
        if (this.ltS > 0) {
            eVar.bo(this.ltS);
        }
        eVar.aE(false);
        eVar.aF(false);
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
        af afVar = new af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        afVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(afVar);
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25));
        final af afVar2 = new af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds31));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null) {
                    ay.a(absThreadDataSupport.bcY().efS, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(afVar2.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        final as asVar = new as(this.mPageContext.getPageActivity());
        asVar.b((Boolean) true);
        asVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && absThreadDataSupport.bcY().efS != null) {
                    ay.a(absThreadDataSupport.bcY().efS, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(asVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) asVar);
        aVar.a((com.baidu.card.i) new ap(this.mPageContext.getPageActivity()));
        k kVar = new k(this.mPageContext.getPageActivity());
        kVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.i) kVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 3;
        cVar.dZe = 3;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(8);
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak tV = aVar.tV();
        tV.setSourceForPb(4);
        am<l> amVar = new am<>(tV);
        amVar.setPageId(this.eSq);
        amVar.bC(this.ltT);
        a(new ab() { // from class: com.baidu.tieba.personPolymeric.a.a.f.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (f.this.afn != null) {
                        f.this.afn.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 4, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, am<l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.dXg == null) {
            return null;
        }
        lVar.vX(lVar.position + 1);
        amVar.tW().setPage(this.ahc);
        if (!this.mIsHost) {
            amVar.tY();
        }
        amVar.b((am<l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.personPolymeric.a.i(lVar);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    public void FR(int i) {
        this.ltS = i;
    }

    public void setTabType(int i) {
        this.gUI = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void FQ(int i) {
        this.ltT = i;
    }
}
