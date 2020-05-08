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
/* loaded from: classes9.dex */
public class g extends l<com.baidu.tbadk.core.data.l, h> {
    private int from;
    private com.baidu.tieba.pb.data.e jqZ;
    private boolean jra;

    public g(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public h b(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.jse.cyh());
        a(hVar);
        return hVar;
    }

    private void a(h hVar) {
        if (hVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (hVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.hFt, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.jrm, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jro, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.aJK, R.color.cp_cont_b, 1, skinType);
                hVar.jrj.setImageDrawable(SvgManager.aOR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrk, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrp, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrq, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.b(hVar.iKM, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.aPr().kL(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).kQ(com.baidu.adp.lib.util.l.getDimens(this.jse.cyh(), R.dimen.tbds10)).aR(hVar.jrh);
            }
            hVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.l lVar, h hVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tbadk.core.data.l) hVar);
        if (lVar == null) {
            return null;
        }
        a(hVar);
        hVar.a(lVar);
        hVar.setBjhFrom(this.from);
        hVar.qQ(this.jra);
        if (this.jqZ != null) {
            hVar.Hx(this.jqZ.getThreadId());
            hVar.qR(this.jqZ.aQe());
            if (this.jqZ.cvr() != null && this.jqZ.cvr().getBaijiahaoData() != null) {
                hVar.setNid(this.jqZ.cvr().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (lVar.threadType == 40) {
                com.baidu.tbadk.core.util.an.uL("c13536").cI("tid", lVar.getTid()).t("fid", lVar.getFid()).af("obj_source", i2).af("obj_locate", lVar.getFloorNum()).cI("obj_id", this.jqZ.getThreadId()).af("obj_type", lVar.aMv() ? 1 : 0).aOO();
            } else {
                com.baidu.tbadk.core.util.an.uL("c13533").cI("tid", lVar.getTid()).t("fid", lVar.getFid()).af("obj_source", i2).af("obj_locate", lVar.getFloorNum()).cI("obj_id", this.jqZ.getThreadId()).aOO();
            }
            if (this.jqZ.aQe()) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13588");
                if (lVar.aMn() != null) {
                    anVar.cI("fid", lVar.aMn().getForumId());
                }
                anVar.cI("tid", lVar.getTid());
                anVar.cI("obj_param1", lVar.mRecomWeight);
                anVar.cI("obj_source", lVar.mRecomSource);
                anVar.af("obj_locate", lVar.getFloorNum());
                anVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                anVar.cI("obj_id", this.jqZ.getThreadId());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (lVar.aIu().getBaijiahaoData() != null) {
                    anVar.cI("obj_param4", lVar.aIu().getBaijiahaoData().oriUgcNid);
                    anVar.cI("obj_param5", lVar.aIu().getBaijiahaoData().oriUgcVid);
                }
                anVar.af("obj_param6", lVar.aMC());
                anVar.cI(TiebaInitialize.Params.AB_TAG, lVar.mRecomAbTag);
                anVar.cI("extra", lVar.mRecomExtra);
                TiebaStatic.log(anVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jqZ = eVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void qQ(boolean z) {
        this.jra = z;
    }
}
