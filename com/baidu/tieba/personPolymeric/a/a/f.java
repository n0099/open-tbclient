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
import com.baidu.card.ak;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes11.dex */
public class f extends com.baidu.adp.widget.ListView.a<k, af<k>> implements com.baidu.tieba.a.f {
    private z<k> acX;
    private String aey;
    private boolean agt;
    public BdUniqueId ebv;
    private int fWX;
    private int jYR;
    private int jYS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agt = true;
        this.jYR = 0;
        this.jYS = 0;
        this.fWX = 0;
        this.acX = new z<k>() { // from class: com.baidu.tieba.personPolymeric.a.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, k kVar) {
                if (view != null && kVar != null && kVar.aIw() != null && view.getId() == R.id.forum_name_text) {
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
        eVar.setPageUniqueId(this.ebv);
        eVar.aX(1024);
        eVar.aX(32768);
        if (this.jYR > 0) {
            eVar.aW(this.jYR);
        }
        eVar.aA(false);
        eVar.aB(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (view != null && aVar2 != null) {
                    int id = view.getId();
                    if (id == R.id.user_name || id == R.id.user_avatar) {
                        com.baidu.tieba.personPolymeric.a.a(view, aVar2, 1);
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.e(0, 0, 0, l.getDimens(this.mContext, R.dimen.tbds20));
        zVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds9));
        aVar.c(zVar);
        aVar.rB().bd(l.getDimens(this.mContext, R.dimen.tbds25));
        final com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.e(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds39));
        zVar2.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aIw() != null && aVar2.aIw().dto != null) {
                    au.a(aVar2.aIw().dto, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(zVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) zVar2);
        final ak akVar = new ak(this.mPageContext.getPageActivity());
        akVar.b((Boolean) true);
        akVar.a(new b.a() { // from class: com.baidu.tieba.personPolymeric.a.a.f.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aIw() != null && aVar2.aIw().dto != null) {
                    au.a(aVar2.aIw().dto, f.this.mContext, 4);
                    com.baidu.tieba.personPolymeric.a.a(akVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) akVar);
        if (this.fWX == 2) {
            com.baidu.card.i iVar = new com.baidu.card.i(this.mPageContext.getPageActivity());
            iVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds24));
            aVar.a((com.baidu.card.h) iVar);
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 3;
        dVar.dmZ = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setShareReportFrom(6);
        agVar.bl(4);
        aVar.b(agVar);
        aVar.rB().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad rC = aVar.rC();
        rC.bc(4);
        af<k> afVar = new af<>(rC);
        afVar.setPageId(this.ebv);
        afVar.bk(this.jYS);
        a(new v() { // from class: com.baidu.tieba.personPolymeric.a.a.f.5
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    k kVar = (k) mVar;
                    kVar.objType = 1;
                    if (f.this.acX != null) {
                        f.this.acX.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 4, false);
                    afVar2.rD().b(new a.C0074a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, af<k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqA == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        afVar.rD().setPage(this.aey);
        if (!this.mIsHost) {
            afVar.rF();
        }
        afVar.b((af<k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.acX);
        com.baidu.tieba.personPolymeric.a.e(kVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void AG(int i) {
        this.jYR = i;
    }

    public void setTabType(int i) {
        this.fWX = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void AF(int i) {
        this.jYS = i;
    }
}
