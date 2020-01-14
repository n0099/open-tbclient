package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.ai;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class h extends com.baidu.adp.widget.ListView.a<k, af<k>> implements com.baidu.tieba.a.f {
    private z<k> JE;
    private String Lg;
    private boolean Nj;
    public BdUniqueId dxg;
    private int fpl;
    private int jlW;
    private int jlX;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Nj = true;
        this.jlW = 0;
        this.jlX = 0;
        this.fpl = 0;
        this.JE = new z<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.axQ() != null && view.getId() == R.id.forum_name_text) {
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
        eVar.setPageUniqueId(this.dxg);
        eVar.aI(1024);
        eVar.aI(32768);
        if (this.jlW > 0) {
            eVar.aH(this.jlW);
        }
        eVar.Y(false);
        eVar.Z(false);
        aVar.a(eVar);
        ai aiVar = new ai(this.mPageContext.getPageActivity());
        aVar.c(aiVar);
        aVar.mS().aN(l.getDimens(this.mContext, R.dimen.tbds25));
        aiVar.aW(2);
        if (this.fpl == 2) {
            aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 3;
        dVar.cJD = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setShareReportFrom(6);
        agVar.aV(4);
        aVar.b(agVar);
        aVar.mS().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad mT = aVar.mT();
        mT.aM(4);
        af<k> afVar = new af<>(mT);
        afVar.setPageId(this.dxg);
        afVar.aU(this.jlX);
        a(new s() { // from class: com.baidu.tieba.personPolymeric.a.a.h.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (h.this.JE != null) {
                        h.this.JE.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, af<k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cNb == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        afVar.mU().setPage(this.Lg);
        if (!this.mIsHost) {
            afVar.mW();
        }
        afVar.b((af<k>) kVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        com.baidu.tieba.personPolymeric.a.d(kVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void zQ(int i) {
        this.jlW = i;
    }

    public void setTabType(int i) {
        this.fpl = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void zP(int i) {
        this.jlX = i;
    }
}
