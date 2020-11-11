package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.card.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes24.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.f, am<com.baidu.tieba.card.data.f>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.f> afF;
    private String ahu;
    public BdUniqueId fsQ;
    private int hBz;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mbA;
    private int mbz;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mbz = 0;
        this.mbA = 0;
        this.hBz = 0;
        this.afF = new ab<com.baidu.tieba.card.data.f>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.f fVar) {
                if (view != null && fVar != null && fVar.bjZ() != null) {
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
        cIV();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<com.baidu.tieba.card.data.f> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsQ);
        eVar.b(this.mPageContext);
        eVar.bp(32768);
        if (this.mbz > 0) {
            eVar.bo(this.mbz);
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
        aVar.tU().bv(l.getDimens(this.mContext, R.dimen.tbds25));
        com.baidu.card.c cVar = new com.baidu.card.c(this.mPageContext.getPageActivity());
        cVar.setOnCardSubClickListener(new ab<AbsThreadDataSupport>() { // from class: com.baidu.tieba.personPolymeric.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                a.this.b(view, absThreadDataSupport);
            }
        });
        aVar.c(cVar);
        aVar.a((com.baidu.card.i) new k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar2 = new com.baidu.tbadk.core.data.c();
        cVar2.ezt = 3;
        cVar2.ezz = 3;
        anVar.setAgreeStatisticData(cVar2);
        anVar.setFrom(8);
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak tV = aVar.tV();
        tV.setSourceForPb(4);
        am<com.baidu.tieba.card.data.f> amVar = new am<>(tV);
        amVar.setPageId(this.fsQ);
        amVar.bC(this.mbA);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.personPolymeric.a.a.a.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.f fVar, am<com.baidu.tieba.card.data.f> amVar) {
        if (fVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        fVar.xj(fVar.position + 1);
        amVar.tW().setPage(this.ahu);
        if (!this.mIsHost) {
            amVar.tY();
        }
        amVar.b((am<com.baidu.tieba.card.data.f>) fVar);
        amVar.tW().a(this.afF);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.i(fVar);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.f) && (view.getTag() instanceof am)) {
            com.baidu.tieba.card.data.f fVar = (com.baidu.tieba.card.data.f) qVar;
            fVar.objType = 1;
            ay.a((AbsThreadDataSupport) fVar, view.getContext(), 4, false);
            ((am) view.getTag()).tW().b(new a.C0097a(1));
        }
    }

    private void cIV() {
        com.baidu.tieba.card.data.l.ibv = "c13542";
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

    public void Hd(int i) {
        this.mbz = i;
    }

    public void setTabType(int i) {
        this.hBz = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Hc(int i) {
        this.mbA = i;
    }
}
