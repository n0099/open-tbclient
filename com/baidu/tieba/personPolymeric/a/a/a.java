package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.e;
import com.baidu.card.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
/* loaded from: classes11.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.e, ak<com.baidu.tieba.card.data.e>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.e> adX;
    private String afG;
    public BdUniqueId eyE;
    private int gyV;
    private int kLR;
    private int kLS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kLR = 0;
        this.kLS = 0;
        this.gyV = 0;
        this.adX = new aa<com.baidu.tieba.card.data.e>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.e eVar) {
                if (view != null && eVar != null && eVar.aPS() != null) {
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
        cjQ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.e> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.b(this.mPageContext);
        eVar.be(32768);
        if (this.kLR > 0) {
            eVar.bd(this.kLR);
        }
        eVar.aD(false);
        eVar.aE(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.a.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                a.this.a(view, absThreadDataSupport);
            }
        });
        aVar.a(eVar);
        aVar.sc().bk(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.c cVar = new com.baidu.card.c(this.mPageContext.getPageActivity());
        cVar.setOnCardSubClickListener(new aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                a.this.a(view, absThreadDataSupport);
            }
        });
        aVar.c(cVar);
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar2 = new com.baidu.tbadk.core.data.c();
        cVar2.dHq = 3;
        cVar2.dHw = 3;
        alVar.setAgreeStatisticData(cVar2);
        alVar.setFrom(8);
        alVar.setShareReportFrom(6);
        alVar.setFromForPb(4);
        aVar.b(alVar);
        aVar.sc().setBackgroundResource(R.drawable.addresslist_item_bg);
        ai sd = aVar.sd();
        sd.setSourceForPb(4);
        ak<com.baidu.tieba.card.data.e> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        akVar.br(this.kLS);
        a(new z() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.e eVar, ak<com.baidu.tieba.card.data.e> akVar) {
        if (eVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        eVar.sR(eVar.position + 1);
        akVar.se().setPage(this.afG);
        if (!this.mIsHost) {
            akVar.sg();
        }
        akVar.b((ak<com.baidu.tieba.card.data.e>) eVar);
        akVar.se().a(this.adX);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.h(eVar);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ak)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            aw.a((AbsThreadDataSupport) eVar, view.getContext(), 4, false);
            ((ak) view.getTag()).se().b(new a.C0098a(1));
        }
    }

    private void cjQ() {
        k.gUC = "c13542";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
        if (view != null && absThreadDataSupport != null && view.getId() != -1) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 1);
            } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
                com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 3);
            }
        }
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
