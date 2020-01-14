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
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, af<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.e> JE;
    private String Lg;
    public BdUniqueId dxg;
    private int fpl;
    private int jlW;
    private int jlX;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jlW = 0;
        this.jlX = 0;
        this.fpl = 0;
        this.JE = new z<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                if (view != null && eVar != null && eVar.axQ() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.bottom_mask) {
                        com.baidu.tieba.personPolymeric.a.a(view, eVar, 2);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, eVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.b(this.mPageContext);
        eVar.aI(32768);
        if (this.jlW > 0) {
            eVar.aH(this.jlW);
        }
        eVar.Y(false);
        eVar.Z(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.a.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                a.this.a(view, aVar2);
            }
        });
        aVar.a(eVar);
        aVar.mS().aN(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.c cVar = new com.baidu.card.c(this.mPageContext.getPageActivity());
        cVar.setOnCardSubClickListener(new z<com.baidu.tbadk.core.data.a>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tbadk.core.data.a aVar2) {
                a.this.a(view, aVar2);
            }
        });
        aVar.c(cVar);
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
        af<com.baidu.tieba.card.data.e> afVar = new af<>(mT);
        afVar.setPageId(this.dxg);
        afVar.aU(this.jlX);
        a(new s() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, mVar);
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, af<com.baidu.tieba.card.data.e> afVar) {
        if (eVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        eVar.rm(eVar.position + 1);
        afVar.mU().setPage(this.Lg);
        if (!this.mIsHost) {
            afVar.mW();
        }
        afVar.b((af<com.baidu.tieba.card.data.e>) eVar);
        afVar.mU().a(this.JE);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.d(eVar);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if ((mVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof af)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) mVar;
            eVar.objType = 1;
            au.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 4, false);
            ((af) view.getTag()).mU().b(new a.C0050a(1));
        }
    }

    private void bNs() {
        k.fKw = "c13542";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tbadk.core.data.a aVar) {
        if (view != null && aVar != null && view.getId() != -1) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                com.baidu.tieba.personPolymeric.a.a(view, aVar, 1);
            } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
                com.baidu.tieba.personPolymeric.a.a(view, aVar, 3);
            }
        }
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
