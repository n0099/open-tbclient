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
    private com.baidu.tieba.pb.data.f lFA;
    private boolean lFB;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public PbBjhRecommendViewHolder e(ViewGroup viewGroup) {
        PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lHa.dlL());
        a(pbBjhRecommendViewHolder);
        return pbBjhRecommendViewHolder;
    }

    private void a(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        if (pbBjhRecommendViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbBjhRecommendViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbBjhRecommendViewHolder.jPe, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbBjhRecommendViewHolder.fEX, R.color.CAM_X0203, skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(pbBjhRecommendViewHolder.lFM, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lFO, R.color.CAM_X0302, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.bgU, R.color.CAM_X0105, 1, skinType);
                pbBjhRecommendViewHolder.jZq.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lFK, R.color.CAM_X0101, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lFP, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(pbBjhRecommendViewHolder.lFQ, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ao.c(pbBjhRecommendViewHolder.bRa, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.f.a.btb().oJ(0).m(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).oQ(com.baidu.adp.lib.util.l.getDimens(this.lHa.dlL(), R.dimen.tbds10)).bz(pbBjhRecommendViewHolder.lFI);
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
        pbBjhRecommendViewHolder.uF(this.lFB);
        if (this.lFA != null) {
            pbBjhRecommendViewHolder.Oy(this.lFA.getThreadId());
            pbBjhRecommendViewHolder.uG(this.lFA.djn());
            if (this.lFA.diN() != null && this.lFA.diN().getBaijiahaoData() != null) {
                pbBjhRecommendViewHolder.setNid(this.lFA.diN().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (oVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.AM("c13536").dW("tid", oVar.getTid()).w("fid", oVar.getFid()).an("obj_source", i2).an("obj_locate", oVar.getFloorNum()).dW("obj_id", this.lFA.getThreadId()).an("obj_type", oVar.bpu() ? 1 : 0).bsu();
            } else {
                com.baidu.tbadk.core.util.aq.AM("c13533").dW("tid", oVar.getTid()).w("fid", oVar.getFid()).an("obj_source", i2).an("obj_locate", oVar.getFloorNum()).dW("obj_id", this.lFA.getThreadId()).bsu();
            }
            if (this.lFA.djn()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (oVar.bpo() != null) {
                    aqVar.dW("fid", oVar.bpo().getForumId());
                }
                aqVar.dW("tid", oVar.getTid());
                aqVar.dW("obj_param1", oVar.mRecomWeight);
                aqVar.dW("obj_source", oVar.mRecomSource);
                aqVar.an("obj_locate", oVar.getFloorNum());
                aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dW("obj_id", this.lFA.getThreadId());
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                if (oVar.bkV().getBaijiahaoData() != null) {
                    aqVar.dW("obj_param4", oVar.bkV().getBaijiahaoData().oriUgcNid);
                    aqVar.dW("obj_param5", oVar.bkV().getBaijiahaoData().oriUgcVid);
                }
                aqVar.an("obj_param6", oVar.bpA());
                aqVar.dW("ab_tag", oVar.mRecomAbTag);
                aqVar.dW("extra", oVar.mRecomExtra);
                TiebaStatic.log(aqVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lFA = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uF(boolean z) {
        this.lFB = z;
    }
}
