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
    private aa<l> ahf;
    private s anl;
    public BdUniqueId fJu;
    private as iNy;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (this.iNy != null && this.iNy.tE() != null && this.iNy.tE().dBx() != null) {
            if (view.getId() == this.iNy.tE().dBx().getId()) {
                com.baidu.tieba.pb.c.a.a(lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.pb.c.a.a(lVar, 1);
            }
        }
    }

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahf = new aa<l>() { // from class: com.baidu.tieba.pb.pb.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                com.baidu.tieba.card.s.cva().mG(true);
                if (lVar != null && lVar.boO() != null && !StringUtils.isNull(lVar.boO().getTid())) {
                    if (lVar.boO().eVz <= 0) {
                        h.this.b(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ai(lVar.boO()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anl = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setPageUniqueId(this.fJu);
        gVar.setFrom("pb");
        gVar.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.pb.pb.adapter.h.2
            @Override // com.baidu.card.a.InterfaceC0089a
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
        this.iNy = gVar;
        aVar.c(this.iNy);
        if (this.iNy != null) {
            this.iNy.setStageType("2002");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fJu);
        a2.a(this.ahf);
        a2.setSourceForPb(0);
        a(new w() { // from class: com.baidu.tieba.pb.pb.adapter.h.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (h.this.ahf != null) {
                        h.this.ahf.a(threadCardViewHolder.getView(), lVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 0, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder.ty().b(new a.C0090a(1));
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
        lVar.yA(lVar.position + 1);
        autoVideoCardViewHolder.ty().setPosition(i);
        lVar.sourceType = 0;
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<l>) lVar);
        autoVideoCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.ty().a(this.ahf);
        return autoVideoCardViewHolder.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = "6";
            oVar.anD = lVar.tid;
            if (lVar.boO() != null) {
                oVar.fPy = String.valueOf(lVar.boO().getFid());
                if (lVar.boO().brH() != null) {
                    oVar.mDM = lVar.boO().brH().video_md5;
                    oVar.mDO = String.valueOf(lVar.boO().brH().is_vertical);
                }
            }
            oVar.eQd = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mDL = lVar.cvn();
            oVar.mDI = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.cvm());
        }
        return oVar;
    }
}
