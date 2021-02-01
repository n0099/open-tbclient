package com.baidu.tieba.newdetail.adapter.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes8.dex */
public class k extends a<ca, AutoVideoCardViewHolder<cb>> {
    private ab<cb> agg;
    private s amk;
    private BdUniqueId fGZ;
    private as iOz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view, cb cbVar) {
        com.baidu.tieba.newdetail.b.a(this, cbVar);
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<cb>() { // from class: com.baidu.tieba.newdetail.adapter.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                t.csu().mG(true);
                k.this.h(view, cbVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.fGZ = bdUniqueId2;
    }

    public void a(s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.newdetail.adapter.a.k.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(gVar.getVideoContainer());
                    if (!(aVar2 instanceof cb)) {
                        az.a(aVar2, k.this.mContext, 17, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, k.this.mContext, 17, false, bs);
                }
            }
        });
        this.iOz = gVar;
        this.iOz.setPageUniqueId(this.fGZ);
        this.iOz.setFrom(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.iOz.setStageType("2001");
        aVar.c(this.iOz);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        AutoVideoCardViewHolder<cb> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fGZ);
        a2.a(this.agg);
        a2.setSourceForPb(17);
        a(new w() { // from class: com.baidu.tieba.newdetail.adapter.a.k.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eJQ;
                    cbVar.objType = 1;
                    if (k.this.agg != null) {
                        k.this.agg.a(autoVideoCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 17, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, AutoVideoCardViewHolder<cb> autoVideoCardViewHolder) {
        if (caVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        caVar.eJQ.eOs = getPositionByType(i) + 1;
        autoVideoCardViewHolder.tj().setPosition(i);
        autoVideoCardViewHolder.setVideoStatsData(al(caVar.eJQ));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<cb>) caVar.eJQ);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.newdetail.b.b(this, caVar);
        return autoVideoCardViewHolder.getView();
    }

    private o al(cb cbVar) {
        o oVar = null;
        if (cbVar != null) {
            oVar = new o();
            oVar.mLocate = "20";
            oVar.amC = cbVar.tid;
            oVar.mSource = cbVar.mRecomSource;
            oVar.mIe = cbVar.mRecomAbTag;
            oVar.mIf = cbVar.mRecomWeight;
            oVar.mIg = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.mFloor = String.valueOf(cbVar.eOs);
            if (cbVar.bpi() != null) {
                oVar.eNE = String.valueOf(cbVar.bpi().eUx);
            }
            if (cbVar.bln() != null) {
                oVar.fNd = String.valueOf(cbVar.bln().getFid());
                oVar.mIn = cbVar.bln().bmo();
                if (cbVar.bln().boh() != null) {
                    oVar.mIj = cbVar.bln().boh().video_md5;
                    oVar.mIl = String.valueOf(cbVar.bln().boh().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (cbVar.bln() != null && cbVar.bln().getBaijiahaoData() != null) {
                oVar.eTz = cbVar.bln().getBaijiahaoData().oriUgcNid;
                oVar.mVid = cbVar.bln().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
