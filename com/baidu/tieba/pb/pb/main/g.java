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
/* loaded from: classes6.dex */
public class g extends m<com.baidu.tbadk.core.data.l, h> {
    private int from;
    private com.baidu.tieba.pb.data.f izO;
    private boolean izP;

    public g(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public h b(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.iAW.ckE());
        a(hVar);
        return hVar;
    }

    private void a(h hVar) {
        if (hVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (hVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.gOH, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.iAb, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iAd, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.amJ, R.color.cp_cont_b, 1, skinType);
                hVar.izY.setImageDrawable(SvgManager.aDW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.izZ, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iAe, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iAf, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.b(hVar.hTy, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.f.a.aEt().kk(0).h(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).kp(com.baidu.adp.lib.util.l.getDimens(this.iAW.ckE(), R.dimen.tbds10)).aM(hVar.izW);
            }
            hVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.l lVar, h hVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tbadk.core.data.l) hVar);
        if (lVar == null) {
            return null;
        }
        a(hVar);
        hVar.a(lVar);
        hVar.setBjhFrom(this.from);
        hVar.pr(this.izP);
        if (this.izO != null) {
            hVar.Fn(this.izO.getThreadId());
            hVar.ps(this.izO.cih());
            if (this.izO.chK() != null && this.izO.chK().getBaijiahaoData() != null) {
                hVar.setNid(this.izO.chK().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (lVar.threadType == 40) {
                com.baidu.tbadk.core.util.an.tb("c13536").cp("tid", lVar.getTid()).s("fid", lVar.getFid()).Z("obj_source", i2).Z("obj_locate", lVar.getFloorNum()).cp("obj_id", this.izO.getThreadId()).Z("obj_type", lVar.aBy() ? 1 : 0).aDT();
            } else {
                com.baidu.tbadk.core.util.an.tb("c13533").cp("tid", lVar.getTid()).s("fid", lVar.getFid()).Z("obj_source", i2).Z("obj_locate", lVar.getFloorNum()).cp("obj_id", this.izO.getThreadId()).aDT();
            }
            if (this.izO.cih()) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13588");
                if (lVar.aBq() != null) {
                    anVar.cp("fid", lVar.aBq().getForumId());
                }
                anVar.cp("tid", lVar.getTid());
                anVar.cp("obj_param1", lVar.mRecomWeight);
                anVar.cp("obj_source", lVar.mRecomSource);
                anVar.Z("obj_locate", lVar.getFloorNum());
                anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                anVar.cp("obj_id", this.izO.getThreadId());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (lVar.axx().getBaijiahaoData() != null) {
                    anVar.cp("obj_param4", lVar.axx().getBaijiahaoData().oriUgcNid);
                    anVar.cp("obj_param5", lVar.axx().getBaijiahaoData().oriUgcVid);
                }
                anVar.Z("obj_param6", lVar.aBG());
                anVar.cp(TiebaInitialize.Params.AB_TAG, lVar.mRecomAbTag);
                anVar.cp("extra", lVar.mRecomExtra);
                TiebaStatic.log(anVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.izO = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void pr(boolean z) {
        this.izP = z;
    }
}
