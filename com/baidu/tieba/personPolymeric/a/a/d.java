package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.j;
import com.baidu.card.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
/* loaded from: classes18.dex */
public class d extends com.baidu.adp.widget.ListView.a<l, al<l>> implements com.baidu.tieba.a.f {
    private aa<l> aeT;
    private String agH;
    private boolean ajr;
    public BdUniqueId ePv;
    private int gQW;
    private int lkK;
    private int lkL;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.lkK = 0;
        this.lkL = 0;
        this.gQW = 0;
        this.aeT = new aa<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bce() != null && view.getId() == R.id.forum_name_text) {
                    com.baidu.tieba.personPolymeric.a.a(view, lVar, 7);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.bl(1024);
        eVar.bl(32768);
        if (this.lkK > 0) {
            eVar.bk(this.lkK);
        }
        eVar.aE(false);
        eVar.aF(false);
        aVar.a(eVar);
        aVar.c(new s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 3;
        cVar.dWQ = 3;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(8);
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aj tQ = aVar.tQ();
        tQ.setSourceForPb(4);
        al<l> alVar = new al<>(tQ);
        alVar.setPageId(this.ePv);
        alVar.by(this.lkL);
        a(new ab() { // from class: com.baidu.tieba.personPolymeric.a.a.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (d.this.aeT != null) {
                        d.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 4, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, al<l> alVar) {
        if (lVar == null || alVar == null || alVar.tR() == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agH);
        }
        if (!this.mIsHost) {
            alVar.tT();
        }
        alVar.b((al<l>) lVar);
        alVar.b(this.aeT);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.personPolymeric.a.h(lVar);
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
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
