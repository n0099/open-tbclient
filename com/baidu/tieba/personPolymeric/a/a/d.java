package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.k;
import com.baidu.card.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
/* loaded from: classes24.dex */
public class d extends com.baidu.adp.widget.ListView.a<l, am<l>> implements com.baidu.tieba.a.f {
    private ab<l> afF;
    private String ahu;
    private boolean akk;
    public BdUniqueId fmX;
    private int hvC;
    private int lVA;
    private int lVB;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akk = true;
        this.lVA = 0;
        this.lVB = 0;
        this.hvC = 0;
        this.afF = new ab<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bhz() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, lVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fmX);
        eVar.bp(1024);
        eVar.bp(32768);
        if (this.lVA > 0) {
            eVar.bo(this.lVA);
        }
        eVar.aE(false);
        eVar.aF(false);
        aVar.a(eVar);
        aVar.c(new t(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 3;
        cVar.etG = 3;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(8);
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak tV = aVar.tV();
        tV.setSourceForPb(4);
        am<l> amVar = new am<>(tV);
        amVar.setPageId(this.fmX);
        amVar.bC(this.lVB);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.personPolymeric.a.a.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (d.this.afF != null) {
                        d.this.afF.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 4, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, am<l> amVar) {
        if (lVar == null || amVar == null || amVar.tW() == null) {
            return null;
        }
        lVar.wW(lVar.position + 1);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahu);
        }
        if (!this.mIsHost) {
            amVar.tY();
        }
        amVar.b((am<l>) lVar);
        amVar.b(this.afF);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.i(lVar);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    public void GQ(int i) {
        this.lVA = i;
    }

    public void setTabType(int i) {
        this.hvC = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void GP(int i) {
        this.lVB = i;
    }
}
