package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes20.dex */
public class e extends a<bw, am<bx>> {
    private ab<bx> afK;
    private boolean akn;
    private v alH;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akn = true;
        this.afK = new ab<bx>() { // from class: com.baidu.tieba.newdetail.adapter.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                t.cnT().lO(true);
                e.this.g(view, bxVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.fsa = bdUniqueId2;
    }

    public void a(v vVar) {
        this.alH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, bx bxVar) {
        com.baidu.tieba.newdetail.b.a(this, bxVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        y yVar = new y(this.mPageContext.getPageActivity());
        yVar.setFrom("index");
        yVar.setFromCDN(this.akn);
        aVar.c(yVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        a2.setSourceForPb(17);
        am amVar = new am(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.newdetail.adapter.a.e.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (e.this.afK != null) {
                        e.this.afK.a(amVar2.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 17, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bx> amVar) {
        if (bwVar == null || amVar == null || amVar.getView() == null || bwVar.evQ == null) {
            return null;
        }
        bwVar.evQ.eAb = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        amVar.b((am<bx>) bwVar.evQ);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        com.baidu.tieba.newdetail.b.b(this, bwVar);
        y yVar = (y) amVar.tW().tP();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.agK.akM.getLayoutParams();
        layoutParams.width = bwVar.eBO;
        layoutParams.height = bwVar.eBP;
        if (yVar.agK.akM.getVisibility() != 8) {
            yVar.agK.akM.setLayoutParams(layoutParams);
        }
        return amVar.getView();
    }
}
