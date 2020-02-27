package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes11.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, af<k>> implements com.baidu.tieba.a.f {
    private z<k> JZ;
    private String LC;
    private boolean NJ;
    public BdUniqueId dBj;
    private int frP;
    private int jmQ;
    private int jmR;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.NJ = true;
        this.jmQ = 0;
        this.jmR = 0;
        this.frP = 0;
        this.JZ = new z<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aAe() != null && view.getId() == R.id.forum_name_text) {
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
    public af<k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBj);
        eVar.aL(1024);
        eVar.aL(32768);
        if (this.jmQ > 0) {
            eVar.aK(this.jmQ);
        }
        eVar.ab(false);
        eVar.ac(false);
        aVar.a(eVar);
        aVar.c(new p(this.mPageContext.getPageActivity()));
        if (this.frP == 2) {
            aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 3;
        dVar.cNG = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setShareReportFrom(6);
        agVar.aZ(4);
        aVar.b(agVar);
        aVar.ni().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad nj = aVar.nj();
        nj.aQ(4);
        af<k> afVar = new af<>(nj);
        afVar.setPageId(this.dBj);
        afVar.aY(this.jmR);
        a(new s() { // from class: com.baidu.tieba.personPolymeric.a.a.d.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (d.this.JZ != null) {
                        d.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, af<k> afVar) {
        if (kVar == null || afVar == null || afVar.nk() == null) {
            return null;
        }
        kVar.rt(kVar.position + 1);
        if (afVar.nk() instanceof com.baidu.tieba.a.e) {
            afVar.nk().setPage(this.LC);
        }
        if (!this.mIsHost) {
            afVar.nm();
        }
        afVar.b((af<k>) kVar);
        afVar.b(this.JZ);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.e(kVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    public void zX(int i) {
        this.jmQ = i;
    }

    public void setTabType(int i) {
        this.frP = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void zW(int i) {
        this.jmR = i;
    }
}
