package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h extends l<com.baidu.tbadk.core.data.p, PbBjhRecommendViewHolder> {
    private int from;
    private com.baidu.tieba.pb.data.f lQH;
    private boolean lQI;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cq */
    public PbBjhRecommendViewHolder e(ViewGroup viewGroup) {
        PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lSl.doq());
        a(pbBjhRecommendViewHolder);
        return pbBjhRecommendViewHolder;
    }

    private void a(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        if (pbBjhRecommendViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbBjhRecommendViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbBjhRecommendViewHolder.jYW, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbBjhRecommendViewHolder.fII, R.color.CAM_X0203, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbBjhRecommendViewHolder.lQT, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lQV, R.color.CAM_X0302, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.blL, R.color.CAM_X0105, 1, skinType);
                pbBjhRecommendViewHolder.kjk.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lQR, R.color.CAM_X0101, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lQW, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lQX, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.c(pbBjhRecommendViewHolder.bWp, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.f.a.bty().oP(0).m(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).oW(com.baidu.adp.lib.util.l.getDimens(this.lSl.doq(), R.dimen.tbds10)).bv(pbBjhRecommendViewHolder.lQP);
            }
            pbBjhRecommendViewHolder.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.p pVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) pVar, (com.baidu.tbadk.core.data.p) pbBjhRecommendViewHolder);
        if (pVar == null) {
            return null;
        }
        a(pbBjhRecommendViewHolder);
        pbBjhRecommendViewHolder.a(pVar);
        pbBjhRecommendViewHolder.setBjhFrom(this.from);
        pbBjhRecommendViewHolder.uU(this.lQI);
        if (this.lQH != null) {
            pbBjhRecommendViewHolder.Pw(this.lQH.getThreadId());
            pbBjhRecommendViewHolder.uV(this.lQH.dlP());
            if (this.lQH.dlp() != null && this.lQH.dlp().getBaijiahaoData() != null) {
                pbBjhRecommendViewHolder.setNid(this.lQH.dlp().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (pVar.threadType == 40) {
                com.baidu.tbadk.core.util.ar.Bk("c13536").dR("tid", pVar.getTid()).v("fid", pVar.getFid()).aq("obj_source", i2).aq("obj_locate", pVar.getFloorNum()).dR("obj_id", this.lQH.getThreadId()).aq("obj_type", pVar.bpO() ? 1 : 0).bsR();
            } else {
                com.baidu.tbadk.core.util.ar.Bk("c13533").dR("tid", pVar.getTid()).v("fid", pVar.getFid()).aq("obj_source", i2).aq("obj_locate", pVar.getFloorNum()).dR("obj_id", this.lQH.getThreadId()).bsR();
            }
            if (this.lQH.dlP()) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13588");
                if (pVar.bpI() != null) {
                    arVar.dR("fid", pVar.bpI().getForumId());
                }
                arVar.dR("tid", pVar.getTid());
                arVar.dR("obj_param1", pVar.mRecomWeight);
                arVar.dR("obj_source", pVar.mRecomSource);
                arVar.aq("obj_locate", pVar.getFloorNum());
                arVar.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                arVar.dR("obj_id", this.lQH.getThreadId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (pVar.blp().getBaijiahaoData() != null) {
                    arVar.dR("obj_param4", pVar.blp().getBaijiahaoData().oriUgcNid);
                    arVar.dR("obj_param5", pVar.blp().getBaijiahaoData().oriUgcVid);
                }
                arVar.aq("obj_param6", pVar.bpU());
                arVar.dR("ab_tag", pVar.mRecomAbTag);
                arVar.dR("extra", pVar.mRecomExtra);
                TiebaStatic.log(arVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lQH = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uU(boolean z) {
        this.lQI = z;
    }
}
