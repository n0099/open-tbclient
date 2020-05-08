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
import com.baidu.card.ah;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes11.dex */
public class b extends com.baidu.adp.widget.ListView.a<k, af<k>> implements com.baidu.tieba.a.f {
    private z<k> ada;
    private String aeB;
    private boolean agw;
    public BdUniqueId ebA;
    private int fXc;
    private int jYV;
    private int jYW;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agw = true;
        this.jYV = 0;
        this.jYW = 0;
        this.fXc = 0;
        this.ada = new z<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.b.1
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
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        zVar.e(0, 0, 0, l.getDimens(this.mContext, R.dimen.tbds20));
        zVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(zVar);
        aVar.rB().bd(l.getDimens(this.mContext, R.dimen.tbds25));
        final com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        zVar2.e(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39));
        zVar2.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.b.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aIu() != null && aVar2.aIu().dtt != null) {
                    au.a(aVar2.aIu().dtt, b.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(zVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) zVar2);
        final ah ahVar = new ah(this.mPageContext.getPageActivity());
        ahVar.b((Boolean) true);
        ahVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.b.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aIu() != null && aVar2.aIu().dtt != null) {
                    au.a(aVar2.aIu().dtt, b.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(ahVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) ahVar);
        if (this.fXc == 2) {
            com.baidu.card.i iVar = new com.baidu.card.i(this.mPageContext.getPageActivity());
            iVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds24));
            aVar.a((com.baidu.card.h) iVar);
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
        a(new v() { // from class: com.baidu.tieba.personPolymeric.a.a.b.4
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (b.this.ada != null) {
                        b.this.ada.a(afVar2.getView(), kVar);
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
