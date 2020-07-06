package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes8.dex */
public class e extends a<bt, ak<bu>> {
    private aa<bu> adX;
    private boolean aik;
    private v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.adX = new aa<bu>() { // from class: com.baidu.tieba.newdetail.adapter.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                s.bOB().jI(true);
                e.this.f(view, buVar);
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
        w wVar = new w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setFromCDN(this.aik);
        aVar.c(wVar);
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(17);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.newdetail.adapter.a.e.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (e.this.adX != null) {
                        e.this.adX.a(akVar2.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), 17, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, ak<bu> akVar) {
        if (btVar == null || akVar == null || akVar.getView() == null || btVar.dLi == null) {
            return null;
        }
        btVar.dLi.dJw = getPositionByType(i) + 1;
        akVar.se().setPosition(i);
        akVar.b((ak<bu>) btVar.dLi);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.newdetail.b.b(this, btVar);
        w wVar = (w) akVar.se().rX();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) wVar.aeV.aiS.getLayoutParams();
        layoutParams.width = btVar.dLj;
        layoutParams.height = btVar.dLk;
        if (wVar.aeV.aiS.getVisibility() != 8) {
            wVar.aeV.aiS.setLayoutParams(layoutParams);
        }
        return akVar.getView();
    }
}
