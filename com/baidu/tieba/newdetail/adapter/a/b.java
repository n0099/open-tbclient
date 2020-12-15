package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes21.dex */
public class b extends a<by, am<by>> {
    private ab<by> agG;
    private v amH;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, by byVar) {
        com.baidu.tieba.newdetail.b.a(this, byVar);
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<by>() { // from class: com.baidu.tieba.newdetail.adapter.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                t.csh().mj(true);
                com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
                if (view != null && byVar != null && byVar.bmn() != null && !StringUtils.isNull(byVar.bmn().getTid())) {
                    b.this.g(view, byVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fzO);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 1;
        dVar.eEP = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(1);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(17);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amH);
        a2.setSourceForPb(17);
        am<by> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.newdetail.adapter.a.b.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                b.this.a(view, qVar);
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, am<by> amVar) {
        if (byVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        byVar.eHa = getPositionByType(i) + 1;
        amVar.tZ().setPosition(i);
        amVar.aN(true).a(this.fWC);
        amVar.a(true, Align.ALIGN_RIGHT_BOTTOM);
        amVar.b((am<by>) byVar);
        amVar.tZ().a(this.agG);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.newdetail.b.b(this, byVar);
        return amVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, q qVar) {
        if ((qVar instanceof com.baidu.tieba.card.data.e) && (view.getTag() instanceof am)) {
            com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) qVar;
            eVar.objType = 1;
            az.a((com.baidu.tbadk.core.data.a) eVar, view.getContext(), 17, false);
            ((am) view.getTag()).tZ().b(new a.C0097a(1));
        }
    }

    public void a(v vVar) {
        this.amH = vVar;
    }
}
