package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.j;
import com.baidu.card.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes18.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, ak<k>> implements com.baidu.tieba.a.f {
    private aa<k> adN;
    private String afx;
    private boolean aib;
    public BdUniqueId eEU;
    private int gEw;
    private int kUT;
    private int kUU;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.kUT = 0;
        this.kUU = 0;
        this.gEw = 0;
        this.adN = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.d.1
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
        aVar.a(eVar);
        aVar.c(new r(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
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
        a(new z() { // from class: com.baidu.tieba.personPolymeric.a.a.d.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (d.this.adN != null) {
                        d.this.adN.a(akVar2.getView(), kVar);
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
        if (kVar == null || akVar == null || akVar.sg() == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        if (!this.mIsHost) {
            akVar.si();
        }
        akVar.b((ak<k>) kVar);
        akVar.b(this.adN);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
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
