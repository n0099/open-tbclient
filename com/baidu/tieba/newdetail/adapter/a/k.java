package com.baidu.tieba.newdetail.adapter.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
import com.baidu.tieba.play.o;
/* loaded from: classes15.dex */
public class k extends a<bv, com.baidu.card.a<bw>> {
    private aa<bw> aeT;
    private v akI;
    private BdUniqueId ePv;
    private as hBc;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view, bw bwVar) {
        com.baidu.tieba.newdetail.b.a(this, bwVar);
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<bw>() { // from class: com.baidu.tieba.newdetail.adapter.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                s.cbX().kK(true);
                k.this.h(view, bwVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.ePv = bdUniqueId2;
    }

    public void a(v vVar) {
        this.akI = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new b.a() { // from class: com.baidu.tieba.newdetail.adapter.a.k.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, k.this.mContext, 17, false, aY);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, k.this.mContext, 17, false, aY);
                }
            }
        });
        this.hBc = gVar;
        this.hBc.setPageUniqueId(this.ePv);
        this.hBc.setFrom("14");
        this.hBc.setStageType("2001");
        aVar.c(this.hBc);
        aj a = aVar.a(false, viewGroup, this.akI);
        com.baidu.card.a<bw> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePv);
        a.a(this.aeT);
        a.setSourceForPb(17);
        a(new ab() { // from class: com.baidu.tieba.newdetail.adapter.a.k.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof al)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    if (k.this.aeT != null) {
                        k.this.aeT.a(aVar3.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 17, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.tR().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.a<bw> aVar) {
        if (bvVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        bvVar.dUS.dZb = getPositionByType(i) + 1;
        aVar.tR().setPosition(i);
        aVar.setVideoStatsData(ah(bvVar.dUS));
        aVar.b((com.baidu.card.a<bw>) bvVar.dUS);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeT);
        com.baidu.tieba.newdetail.b.b(this, bvVar);
        return aVar.getView();
    }

    private o ah(bw bwVar) {
        o oVar = null;
        if (bwVar != null) {
            oVar = new o();
            oVar.mLocate = "20";
            oVar.akY = bwVar.tid;
            oVar.mSource = bwVar.mRecomSource;
            oVar.ltc = bwVar.mRecomAbTag;
            oVar.ltd = bwVar.mRecomWeight;
            oVar.lte = "14";
            oVar.mFloor = String.valueOf(bwVar.dZb);
            if (bwVar.bfU() != null) {
                oVar.dYo = String.valueOf(bwVar.bfU().eeO);
            }
            if (bwVar.bce() != null) {
                oVar.eVt = String.valueOf(bwVar.bce().getFid());
                oVar.ltl = bwVar.bce().getNid();
                if (bwVar.bce().beW() != null) {
                    oVar.lth = bwVar.bce().beW().video_md5;
                    oVar.ltj = String.valueOf(bwVar.bce().beW().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.bce() != null && bwVar.bce().getBaijiahaoData() != null) {
                oVar.mNid = bwVar.bce().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bwVar.bce().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
