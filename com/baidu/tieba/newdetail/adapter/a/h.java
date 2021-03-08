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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes7.dex */
public class h extends a<ca, ThreadCardViewHolder<cb>> {
    private ab<ca> ahy;
    private s anC;
    public BdUniqueId fIy;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<ca>() { // from class: com.baidu.tieba.newdetail.adapter.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, ca caVar) {
                if (caVar != null) {
                    t.csH().mG(true);
                    h.this.g(view, caVar.eLr);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fIy = bdUniqueId2;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, cb cbVar) {
        com.baidu.tieba.newdetail.b.a(this, cbVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 22;
        eVar.eNH = 19;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(18);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(18);
        amVar.setFromForPb(17);
        amVar.br(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.anC);
        a2.setSourceForPb(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a(new w() { // from class: com.baidu.tieba.newdetail.adapter.a.h.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eLr;
                    cbVar.objType = 1;
                    if (h.this.ahy != null) {
                        h.this.ahy.a(threadCardViewHolder2.getView(), (ca) nVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 17, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, ca caVar, ThreadCardViewHolder threadCardViewHolder) {
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || caVar.eLr == null) {
            return null;
        }
        caVar.eLr.ePT = getPositionByType(i) + 1;
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj().td() instanceof am) {
            ((am) threadCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.h.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((s) viewGroup, view, i));
                    }
                }
            });
        }
        threadCardViewHolder.b((ThreadCardViewHolder) caVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.ahy);
        com.baidu.tieba.newdetail.b.b(this, caVar);
        return threadCardViewHolder.getView();
    }
}
