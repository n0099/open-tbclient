package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
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
/* loaded from: classes11.dex */
public class h extends com.baidu.adp.widget.ListView.a<k, af<k>> implements com.baidu.tieba.a.f {
    private z<k> ada;
    private String aeB;
    private boolean agw;
    public BdUniqueId ebA;
    private int fXc;
    private int jYV;
    private int jYW;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agw = true;
        this.jYV = 0;
        this.jYW = 0;
        this.fXc = 0;
        this.ada = new z<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aIu() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebA);
        eVar.aX(1024);
        eVar.aX(32768);
        if (this.jYV > 0) {
            eVar.aW(this.jYV);
        }
        eVar.aA(false);
        eVar.aB(false);
        aVar.a(eVar);
        ai aiVar = new ai(this.mPageContext.getPageActivity());
        aVar.c(aiVar);
        aVar.rB().bd(l.getDimens(this.mContext, R.dimen.tbds25));
        aiVar.bm(2);
        if (this.fXc == 2) {
            aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 3;
        dVar.dnd = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setShareReportFrom(6);
        agVar.bl(4);
        aVar.b(agVar);
        aVar.rB().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad rC = aVar.rC();
        rC.bc(4);
        af<k> afVar = new af<>(rC);
        afVar.setPageId(this.ebA);
        afVar.bk(this.jYW);
        a(new v() { // from class: com.baidu.tieba.personPolymeric.a.a.h.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (h.this.ada != null) {
                        h.this.ada.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, af<k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqE == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        afVar.rD().setPage(this.aeB);
        if (!this.mIsHost) {
            afVar.rF();
        }
        afVar.b((af<k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        com.baidu.tieba.personPolymeric.a.e(kVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    public void AG(int i) {
        this.jYV = i;
    }

    public void setTabType(int i) {
        this.fXc = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void AF(int i) {
        this.jYW = i;
    }
}
