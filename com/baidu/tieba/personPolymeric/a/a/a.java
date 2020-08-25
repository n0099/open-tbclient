package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.e;
import com.baidu.card.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes18.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, al<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.f> aeT;
    private String agH;
    public BdUniqueId ePv;
    private int gQW;
    private int lkK;
    private int lkL;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.lkK = 0;
        this.lkL = 0;
        this.gQW = 0;
        this.aeT = new aa<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                if (view != null && fVar != null && fVar.bce() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.bottom_mask) {
                        com.baidu.tieba.personPolymeric.a.a(view, fVar, 2);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, fVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyk();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.f> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.b(this.mPageContext);
        eVar.bl(32768);
        if (this.lkK > 0) {
            eVar.bk(this.lkK);
        }
        eVar.aE(false);
        eVar.aF(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.a.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                a.this.b(view, absThreadDataSupport);
            }
        });
        aVar.a(eVar);
        aVar.tP().br(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.c cVar = new com.baidu.card.c(this.mPageContext.getPageActivity());
        cVar.setOnCardSubClickListener(new aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                a.this.b(view, absThreadDataSupport);
            }
        });
        aVar.c(cVar);
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar2 = new com.baidu.tbadk.core.data.c();
        cVar2.dWK = 3;
        cVar2.dWQ = 3;
        amVar.setAgreeStatisticData(cVar2);
        amVar.setFrom(8);
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aj tQ = aVar.tQ();
        tQ.setSourceForPb(4);
        al<com.baidu.tieba.card.data.f> alVar = new al<>(tQ);
        alVar.setPageId(this.ePv);
        alVar.by(this.lkL);
        a(new ab() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, al<com.baidu.tieba.card.data.f> alVar) {
        if (fVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        fVar.vy(fVar.position + 1);
        alVar.tR().setPage(this.agH);
        if (!this.mIsHost) {
            alVar.tT();
        }
        alVar.b((al<com.baidu.tieba.card.data.f>) fVar);
        alVar.tR().a(this.aeT);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.h(fVar);
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.f) && (view.getTag() instanceof al)) {
            com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) qVar;
            fVar.objType = 1;
            ay.a((AbsThreadDataSupport) fVar, view.getContext(), 4, false);
            ((al) view.getTag()).tR().b(new a.C0095a(1));
        }
    }

    private void cyk() {
        com.baidu.tieba.card.data.l.hmZ = "c13542";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, AbsThreadDataSupport absThreadDataSupport) {
        if (view != null && absThreadDataSupport != null && view.getId() != -1) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 1);
            } else if (id == R.id.cover_img || id == R.id.bottom_mask) {
                com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 3);
            }
        }
    }

    public void Fq(int i) {
        this.lkK = i;
    }

    public void setTabType(int i) {
        this.gQW = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Fp(int i) {
        this.lkL = i;
    }
}
