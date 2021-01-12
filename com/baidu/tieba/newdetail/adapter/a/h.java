package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes7.dex */
public class h extends a<by, ThreadCardViewHolder<bz>> {
    private aa<by> ago;
    private s amu;
    public BdUniqueId fEN;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<by>() { // from class: com.baidu.tieba.newdetail.adapter.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, by byVar) {
                if (byVar != null) {
                    com.baidu.tieba.card.s.crj().mC(true);
                    h.this.g(view, byVar.eHK);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fEN = bdUniqueId2;
    }

    public void a(s sVar) {
        this.amu = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, bz bzVar) {
        com.baidu.tieba.newdetail.b.a(this, bzVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJO = 22;
        dVar.eJU = 19;
        amVar.setAgreeStatisticData(dVar);
        amVar.setFrom(18);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(18);
        amVar.setFromForPb(17);
        amVar.bq(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amu);
        a2.setSourceForPb(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new w() { // from class: com.baidu.tieba.newdetail.adapter.a.h.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eHK;
                    bzVar.objType = 1;
                    if (h.this.ago != null) {
                        h.this.ago.a(threadCardViewHolder2.getView(), (by) nVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 17, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, by byVar, ThreadCardViewHolder threadCardViewHolder) {
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || byVar.eHK == null) {
            return null;
        }
        byVar.eHK.eMg = getPositionByType(i) + 1;
        threadCardViewHolder.tm().setPosition(i);
        if (threadCardViewHolder.tm().tg() instanceof am) {
            ((am) threadCardViewHolder.tm().tg()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.h.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((s) viewGroup, view, i));
                    }
                }
            });
        }
        threadCardViewHolder.b((ThreadCardViewHolder) byVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        com.baidu.tieba.newdetail.b.b(this, byVar);
        return threadCardViewHolder.getView();
    }
}
