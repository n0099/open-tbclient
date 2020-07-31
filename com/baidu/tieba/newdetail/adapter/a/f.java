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
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes15.dex */
public class f extends a<bu, ak<bv>> {
    private aa<bv> adN;
    private boolean aib;
    private v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.adN = new aa<bv>() { // from class: com.baidu.tieba.newdetail.adapter.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                s.bRL().km(true);
                f.this.f(view, bvVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.eEU = bdUniqueId2;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, bv bvVar) {
        com.baidu.tieba.newdetail.b.a(this, bvVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        x xVar = new x(this.mPageContext.getPageActivity());
        xVar.setFrom("index");
        xVar.setFromCDN(this.aib);
        aVar.c(xVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(17);
        ak akVar = new ak(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.newdetail.adapter.a.f.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (f.this.adN != null) {
                        f.this.adN.a(akVar2.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 17, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, ak<bv> akVar) {
        if (buVar == null || akVar == null || akVar.getView() == null || buVar.dLK == null) {
            return null;
        }
        buVar.dLK.dPI = getPositionByType(i) + 1;
        akVar.sg().setPosition(i);
        akVar.b((ak<bv>) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        com.baidu.tieba.newdetail.b.b(this, buVar);
        return akVar.getView();
    }
}
