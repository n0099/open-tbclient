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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes11.dex */
public class d extends com.baidu.adp.widget.ListView.a<k, ak<k>> implements com.baidu.tieba.a.f {
    private aa<k> adX;
    private String afG;
    private boolean aik;
    public BdUniqueId eyE;
    private int gyV;
    private int kLR;
    private int kLS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.kLR = 0;
        this.kLS = 0;
        this.gyV = 0;
        this.adX = new aa<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aPS() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, kVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.be(1024);
        eVar.be(32768);
        if (this.kLR > 0) {
            eVar.bd(this.kLR);
        }
        eVar.aD(false);
        eVar.aE(false);
        aVar.a(eVar);
        aVar.c(new r(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 3;
        cVar.dHw = 3;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(8);
        alVar.setShareReportFrom(6);
        alVar.setFromForPb(4);
        aVar.b(alVar);
        aVar.sc().setBackgroundResource(R.drawable.addresslist_item_bg);
        ai sd = aVar.sd();
        sd.setSourceForPb(4);
        ak<k> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        akVar.br(this.kLS);
        a(new z() { // from class: com.baidu.tieba.personPolymeric.a.a.d.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (d.this.adX != null) {
                        d.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 4, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, ak<k> akVar) {
        if (kVar == null || akVar == null || akVar.se() == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        if (!this.mIsHost) {
            akVar.sg();
        }
        akVar.b((ak<k>) kVar);
        akVar.b(this.adX);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.h(kVar);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void Cv(int i) {
        this.kLR = i;
    }

    public void setTabType(int i) {
        this.gyV = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Cu(int i) {
        this.kLS = i;
    }
}
