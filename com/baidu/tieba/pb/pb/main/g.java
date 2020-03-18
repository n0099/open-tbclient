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
    private com.baidu.tieba.pb.data.e iGO;
    private boolean iGP;

    public g(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public h b(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.iHT.cnE());
        a(hVar);
        return hVar;
    }

    private void a(h hVar) {
        if (hVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (hVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.gVw, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.iHb, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iHd, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.aqZ, R.color.cp_cont_b, 1, skinType);
                hVar.iGY.setImageDrawable(SvgManager.aGG().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iGZ, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iHe, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iHf, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.b(hVar.iaO, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.aHf().kB(0).h(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).kG(com.baidu.adp.lib.util.l.getDimens(this.iHT.cnE(), R.dimen.tbds10)).aQ(hVar.iGW);
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
        hVar.pM(this.iGP);
        if (this.iGO != null) {
            hVar.FM(this.iGO.getThreadId());
            hVar.pN(this.iGO.aHP());
            if (this.iGO.ckP() != null && this.iGO.ckP().getBaijiahaoData() != null) {
                hVar.setNid(this.iGO.ckP().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (lVar.threadType == 40) {
                com.baidu.tbadk.core.util.an.tu("c13536").cx("tid", lVar.getTid()).s("fid", lVar.getFid()).X("obj_source", i2).X("obj_locate", lVar.getFloorNum()).cx("obj_id", this.iGO.getThreadId()).X("obj_type", lVar.aEj() ? 1 : 0).aGD();
            } else {
                com.baidu.tbadk.core.util.an.tu("c13533").cx("tid", lVar.getTid()).s("fid", lVar.getFid()).X("obj_source", i2).X("obj_locate", lVar.getFloorNum()).cx("obj_id", this.iGO.getThreadId()).aGD();
            }
            if (this.iGO.aHP()) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13588");
                if (lVar.aEb() != null) {
                    anVar.cx("fid", lVar.aEb().getForumId());
                }
                anVar.cx("tid", lVar.getTid());
                anVar.cx("obj_param1", lVar.mRecomWeight);
                anVar.cx("obj_source", lVar.mRecomSource);
                anVar.X("obj_locate", lVar.getFloorNum());
                anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                anVar.cx("obj_id", this.iGO.getThreadId());
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                if (lVar.aAj().getBaijiahaoData() != null) {
                    anVar.cx("obj_param4", lVar.aAj().getBaijiahaoData().oriUgcNid);
                    anVar.cx("obj_param5", lVar.aAj().getBaijiahaoData().oriUgcVid);
                }
                anVar.X("obj_param6", lVar.aEq());
                anVar.cx(TiebaInitialize.Params.AB_TAG, lVar.mRecomAbTag);
                anVar.cx("extra", lVar.mRecomExtra);
                TiebaStatic.log(anVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.iGO = eVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void pM(boolean z) {
        this.iGP = z;
    }
}
