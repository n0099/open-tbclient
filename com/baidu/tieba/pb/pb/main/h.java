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
public class h extends l<com.baidu.tbadk.core.data.o, PbBjhRecommendViewHolder> {
    private int from;
    private com.baidu.tieba.pb.data.f lKf;
    private boolean lKg;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public PbBjhRecommendViewHolder e(ViewGroup viewGroup) {
        PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lLF.dpD());
        a(pbBjhRecommendViewHolder);
        return pbBjhRecommendViewHolder;
    }

    private void a(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        if (pbBjhRecommendViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbBjhRecommendViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbBjhRecommendViewHolder.jTJ, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbBjhRecommendViewHolder.fJE, R.color.CAM_X0203, skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbBjhRecommendViewHolder.lKr, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lKt, R.color.CAM_X0302, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.blJ, R.color.CAM_X0105, 1, skinType);
                pbBjhRecommendViewHolder.kdV.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lKp, R.color.CAM_X0101, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lKu, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lKv, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ao.c(pbBjhRecommendViewHolder.bVM, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.f.a.bwU().qq(0).m(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).qx(com.baidu.adp.lib.util.l.getDimens(this.lLF.dpD(), R.dimen.tbds10)).bz(pbBjhRecommendViewHolder.lKn);
            }
            pbBjhRecommendViewHolder.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.o oVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tbadk.core.data.o) pbBjhRecommendViewHolder);
        if (oVar == null) {
            return null;
        }
        a(pbBjhRecommendViewHolder);
        pbBjhRecommendViewHolder.a(oVar);
        pbBjhRecommendViewHolder.setBjhFrom(this.from);
        pbBjhRecommendViewHolder.uJ(this.lKg);
        if (this.lKf != null) {
            pbBjhRecommendViewHolder.PG(this.lKf.getThreadId());
            pbBjhRecommendViewHolder.uK(this.lKf.dne());
            if (this.lKf.dmE() != null && this.lKf.dmE().getBaijiahaoData() != null) {
                pbBjhRecommendViewHolder.setNid(this.lKf.dmE().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (oVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.BY("c13536").dX("tid", oVar.getTid()).w("fid", oVar.getFid()).an("obj_source", i2).an("obj_locate", oVar.getFloorNum()).dX("obj_id", this.lKf.getThreadId()).an("obj_type", oVar.btn() ? 1 : 0).bwn();
            } else {
                com.baidu.tbadk.core.util.aq.BY("c13533").dX("tid", oVar.getTid()).w("fid", oVar.getFid()).an("obj_source", i2).an("obj_locate", oVar.getFloorNum()).dX("obj_id", this.lKf.getThreadId()).bwn();
            }
            if (this.lKf.dne()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (oVar.bth() != null) {
                    aqVar.dX("fid", oVar.bth().getForumId());
                }
                aqVar.dX("tid", oVar.getTid());
                aqVar.dX("obj_param1", oVar.mRecomWeight);
                aqVar.dX("obj_source", oVar.mRecomSource);
                aqVar.an("obj_locate", oVar.getFloorNum());
                aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dX("obj_id", this.lKf.getThreadId());
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (oVar.boO().getBaijiahaoData() != null) {
                    aqVar.dX("obj_param4", oVar.boO().getBaijiahaoData().oriUgcNid);
                    aqVar.dX("obj_param5", oVar.boO().getBaijiahaoData().oriUgcVid);
                }
                aqVar.an("obj_param6", oVar.btt());
                aqVar.dX("ab_tag", oVar.mRecomAbTag);
                aqVar.dX("extra", oVar.mRecomExtra);
                TiebaStatic.log(aqVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lKf = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uJ(boolean z) {
        this.lKg = z;
    }
}
