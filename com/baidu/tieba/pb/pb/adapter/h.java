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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, AutoVideoCardViewHolder<l>> {
    private aa<l> ago;
    private s amu;
    public BdUniqueId fEN;
    private as iIR;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (this.iIR != null && this.iIR.tt() != null && this.iIR.tt().dxG() != null) {
            if (view.getId() == this.iIR.tt().dxG().getId()) {
                com.baidu.tieba.pb.c.a.a(lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.pb.c.a.a(lVar, 1);
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<l>() { // from class: com.baidu.tieba.pb.pb.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                com.baidu.tieba.card.s.crj().mC(true);
                if (lVar != null && lVar.bkV() != null && !StringUtils.isNull(lVar.bkV().getTid())) {
                    if (lVar.bkV().eQO <= 0) {
                        h.this.b(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ai(lVar.bkV()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.amu = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setPageUniqueId(this.fEN);
        gVar.setFrom("pb");
        gVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.pb.pb.adapter.h.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(gVar.getVideoContainer());
                    if (!(aVar2 instanceof l)) {
                        ay.a(aVar2, h.this.mContext, 0, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, h.this.mContext, 0, false, bw);
                }
            }
        });
        this.iIR = gVar;
        aVar.c(this.iIR);
        if (this.iIR != null) {
            this.iIR.setStageType("2002");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amu);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fEN);
        a2.a(this.ago);
        a2.setSourceForPb(0);
        a(new w() { // from class: com.baidu.tieba.pb.pb.adapter.h.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (h.this.ago != null) {
                        h.this.ago.a(threadCardViewHolder.getView(), lVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 0, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder.tm().b(new a.C0089a(1));
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
        lVar.wT(lVar.position + 1);
        autoVideoCardViewHolder.tm().setPosition(i);
        lVar.sourceType = 0;
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<l>) lVar);
        autoVideoCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tm().a(this.ago);
        return autoVideoCardViewHolder.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = "6";
            oVar.amM = lVar.tid;
            if (lVar.bkV() != null) {
                oVar.fKR = String.valueOf(lVar.bkV().getFid());
                if (lVar.bkV().bnO() != null) {
                    oVar.mzc = lVar.bkV().bnO().video_md5;
                    oVar.mze = String.valueOf(lVar.bkV().bnO().is_vertical);
                }
            }
            oVar.eLs = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mzb = lVar.crw();
            oVar.myY = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.crv());
        }
        return oVar;
    }
}
