package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes8.dex */
public class b extends a<cb, ThreadCardViewHolder<cb>> {
    private ab<cb> agg;
    private s amk;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, cb cbVar) {
        com.baidu.tieba.newdetail.b.a(this, cbVar);
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<cb>() { // from class: com.baidu.tieba.newdetail.adapter.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                t.csB().mG(true);
                com.baidu.tieba.a.d.bKU().dK("page_recommend", "show_");
                if (view != null && cbVar != null && cbVar.bln() != null && !StringUtils.isNull(cbVar.bln().getTid())) {
                    b.this.g(view, cbVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fGZ = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fGZ);
        dVar.b(this.mPageContext);
        aVar.a(dVar);
        aVar.c(new com.baidu.card.b(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 1;
        eVar.eMg = 1;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(17);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amk);
        a2.setSourceForPb(17);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new w() { // from class: com.baidu.tieba.newdetail.adapter.a.b.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                b.this.a(view, nVar);
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (cbVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        cbVar.eOs = getPositionByType(i) + 1;
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.aK(true).a(this.gdT);
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) cbVar);
        threadCardViewHolder.tj().a(this.agg);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.newdetail.b.b(this, cbVar);
        return threadCardViewHolder.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, n nVar) {
        if ((nVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) nVar;
            eVar.objType = 1;
            az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 17, false);
            ((ThreadCardViewHolder) view.getTag()).tj().b(new a.C0089a(1));
        }
    }

    public void a(s sVar) {
        this.amk = sVar;
    }
}
