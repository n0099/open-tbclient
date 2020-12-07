package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
/* loaded from: classes24.dex */
public class b extends com.baidu.adp.widget.ListView.a<k, am<k>> implements com.baidu.tieba.a.f {
    private ab<k> agG;
    private String aiw;
    private boolean alo;
    public BdUniqueId fzO;
    private int hKL;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mpX;
    private int mpY;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alo = true;
        this.mpX = 0;
        this.mpY = 0;
        this.hKL = 0;
        this.agG = new ab<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.bmn() != null && view.getId() == R.id.forum_name_text) {
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
    public am<k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.bt(1024);
        eVar.bt(32768);
        if (this.mpX > 0) {
            eVar.bs(this.mpX);
        }
        eVar.aD(false);
        eVar.aE(false);
        aVar.a(eVar);
        af afVar = new af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(afVar);
        aVar.tY().bz(l.getDimens(this.mContext, R.dimen.tbds25));
        final af afVar2 = new af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar2.e(com.baidu.tbadk.a.b.a.bkK(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.a.bkK(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.b.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, b.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(afVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        final ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.b.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, b.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(aoVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 3;
        dVar.eEP = 3;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(8);
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        ak tX = aVar.tX();
        tX.setSourceForPb(4);
        am<k> amVar = new am<>(tX);
        amVar.setPageId(this.fzO);
        amVar.bE(this.mpY);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.personPolymeric.a.a.b.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (b.this.agG != null) {
                        b.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, am<k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPage(this.aiw);
        if (!this.mIsHost) {
            amVar.ub();
        }
        amVar.b((am<k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.personPolymeric.a.j(kVar);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void Is(int i) {
        this.mpX = i;
    }

    public void setTabType(int i) {
        this.hKL = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Ir(int i) {
        this.mpY = i;
    }
}
