package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes8.dex */
public class h extends a<bt, ak<bu>> {
    private aa<bt> adX;
    private v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<bt>() { // from class: com.baidu.tieba.newdetail.adapter.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bt btVar) {
                if (btVar != null) {
                    s.bOB().jI(true);
                    h.this.f(view, btVar.dLi);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eyE = bdUniqueId2;
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, bu buVar) {
        com.baidu.tieba.newdetail.b.a(this, buVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 22;
        cVar.dHw = 19;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(18);
        alVar.setStType("personalize_page");
        alVar.setShareReportFrom(18);
        alVar.setFromForPb(17);
        alVar.bd(32);
        aVar.b(alVar);
        ai a = aVar.a(true, viewGroup, this.ajy);
        a.setSourceForPb(17);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.newdetail.adapter.a.h.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (h.this.adX != null) {
                        h.this.adX.a(akVar2.getView(), (bt) qVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), 17, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bt btVar, ak akVar) {
        if (btVar == null || akVar == null || akVar.getView() == null || btVar.dLi == null) {
            return null;
        }
        btVar.dLi.dJw = getPositionByType(i) + 1;
        akVar.se().setPosition(i);
        if (akVar.se().rY() instanceof al) {
            ((al) akVar.se().rY()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.h.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((v) viewGroup, view, i));
                    }
                }
            });
        }
        akVar.b((ak) btVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.newdetail.b.b(this, btVar);
        return akVar.getView();
    }
}
