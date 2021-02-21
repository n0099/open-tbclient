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
    private com.baidu.tieba.pb.data.f lOF;
    private boolean lOG;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public PbBjhRecommendViewHolder e(ViewGroup viewGroup) {
        PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lQj.doh());
        a(pbBjhRecommendViewHolder);
        return pbBjhRecommendViewHolder;
    }

    private void a(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        if (pbBjhRecommendViewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (pbBjhRecommendViewHolder.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbBjhRecommendViewHolder.jWU, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbBjhRecommendViewHolder.fHj, R.color.CAM_X0203, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(pbBjhRecommendViewHolder.lOR, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lOT, R.color.CAM_X0302, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.bkl, R.color.CAM_X0105, 1, skinType);
                pbBjhRecommendViewHolder.khh.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lOP, R.color.CAM_X0101, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lOU, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(pbBjhRecommendViewHolder.lOV, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.c(pbBjhRecommendViewHolder.bUP, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.f.a.btv().oO(0).m(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).oV(com.baidu.adp.lib.util.l.getDimens(this.lQj.doh(), R.dimen.tbds10)).bv(pbBjhRecommendViewHolder.lON);
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
        pbBjhRecommendViewHolder.uU(this.lOG);
        if (this.lOF != null) {
            pbBjhRecommendViewHolder.Pq(this.lOF.getThreadId());
            pbBjhRecommendViewHolder.uV(this.lOF.dlG());
            if (this.lOF.dlg() != null && this.lOF.dlg().getBaijiahaoData() != null) {
                pbBjhRecommendViewHolder.setNid(this.lOF.dlg().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (pVar.threadType == 40) {
                com.baidu.tbadk.core.util.ar.Bd("c13536").dR("tid", pVar.getTid()).v("fid", pVar.getFid()).ap("obj_source", i2).ap("obj_locate", pVar.getFloorNum()).dR("obj_id", this.lOF.getThreadId()).ap("obj_type", pVar.bpM() ? 1 : 0).bsO();
            } else {
                com.baidu.tbadk.core.util.ar.Bd("c13533").dR("tid", pVar.getTid()).v("fid", pVar.getFid()).ap("obj_source", i2).ap("obj_locate", pVar.getFloorNum()).dR("obj_id", this.lOF.getThreadId()).bsO();
            }
            if (this.lOF.dlG()) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13588");
                if (pVar.bpG() != null) {
                    arVar.dR("fid", pVar.bpG().getForumId());
                }
                arVar.dR("tid", pVar.getTid());
                arVar.dR("obj_param1", pVar.mRecomWeight);
                arVar.dR("obj_source", pVar.mRecomSource);
                arVar.ap("obj_locate", pVar.getFloorNum());
                arVar.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                arVar.dR("obj_id", this.lOF.getThreadId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (pVar.bln().getBaijiahaoData() != null) {
                    arVar.dR("obj_param4", pVar.bln().getBaijiahaoData().oriUgcNid);
                    arVar.dR("obj_param5", pVar.bln().getBaijiahaoData().oriUgcVid);
                }
                arVar.ap("obj_param6", pVar.bpS());
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
        this.lOF = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uU(boolean z) {
        this.lOG = z;
    }
}
