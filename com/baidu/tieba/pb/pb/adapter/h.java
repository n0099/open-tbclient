package com.baidu.tieba.pb.pb.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.t;
import com.baidu.tieba.play.o;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, AutoVideoCardViewHolder<l>> {
    private ab<l> ahy;
    private s anC;
    public BdUniqueId fIy;
    private as iQw;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (this.iQw != null && this.iQw.tq() != null && this.iQw.tq().dAf() != null) {
            if (view.getId() == this.iQw.tq().dAf().getId()) {
                com.baidu.tieba.pb.c.a.a(lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.pb.c.a.a(lVar, 1);
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<l>() { // from class: com.baidu.tieba.pb.pb.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                t.csH().mG(true);
                if (lVar != null && lVar.blp() != null && !StringUtils.isNull(lVar.blp().getTid())) {
                    if (lVar.blp().eUB <= 0) {
                        h.this.b(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.aj(lVar.blp()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setPageUniqueId(this.fIy);
        gVar.setFrom("pb");
        gVar.a(new a.InterfaceC0094a() { // from class: com.baidu.tieba.pb.pb.adapter.h.2
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(gVar.getVideoContainer());
                    if (!(aVar2 instanceof l)) {
                        az.a(aVar2, h.this.mContext, 0, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, h.this.mContext, 0, false, bs);
                }
            }
        });
        this.iQw = gVar;
        aVar.c(this.iQw);
        if (this.iQw != null) {
            this.iQw.setStageType("2002");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anC);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fIy);
        a2.a(this.ahy);
        a2.setSourceForPb(0);
        a(new w() { // from class: com.baidu.tieba.pb.pb.adapter.h.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (h.this.ahy != null) {
                        h.this.ahy.a(threadCardViewHolder.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 0, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0095a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xe(lVar.position + 1);
        autoVideoCardViewHolder.tj().setPosition(i);
        lVar.sourceType = 0;
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.ahy);
        return autoVideoCardViewHolder.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = "6";
            oVar.anU = lVar.tid;
            if (lVar.blp() != null) {
                oVar.fOD = String.valueOf(lVar.blp().getFid());
                if (lVar.blp().boj() != null) {
                    oVar.mKE = lVar.blp().boj().video_md5;
                    oVar.mKG = String.valueOf(lVar.blp().boj().is_vertical);
                }
            }
            oVar.ePf = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mKD = lVar.csV();
            oVar.mKA = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csU());
        }
        return oVar;
    }
}
