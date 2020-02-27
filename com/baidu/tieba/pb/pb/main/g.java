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
    private com.baidu.tieba.pb.data.e iEZ;
    private boolean iFa;

    public g(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public h b(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.iGe.cng());
        a(hVar);
        return hVar;
    }

    private void a(h hVar) {
        if (hVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (hVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.gUb, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.iFm, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iFo, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.aqO, R.color.cp_cont_b, 1, skinType);
                hVar.iFj.setImageDrawable(SvgManager.aGA().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iFk, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iFp, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.iFq, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.b(hVar.hZa, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.f.a.aGY().kB(0).h(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).kG(com.baidu.adp.lib.util.l.getDimens(this.iGe.cng(), R.dimen.tbds10)).aQ(hVar.iFh);
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
        hVar.pG(this.iFa);
        if (this.iEZ != null) {
            hVar.FM(this.iEZ.getThreadId());
            hVar.pH(this.iEZ.aHI());
            if (this.iEZ.cks() != null && this.iEZ.cks().getBaijiahaoData() != null) {
                hVar.setNid(this.iEZ.cks().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (lVar.threadType == 40) {
                com.baidu.tbadk.core.util.an.tv("c13536").cy("tid", lVar.getTid()).s("fid", lVar.getFid()).X("obj_source", i2).X("obj_locate", lVar.getFloorNum()).cy("obj_id", this.iEZ.getThreadId()).X("obj_type", lVar.aEd() ? 1 : 0).aGx();
            } else {
                com.baidu.tbadk.core.util.an.tv("c13533").cy("tid", lVar.getTid()).s("fid", lVar.getFid()).X("obj_source", i2).X("obj_locate", lVar.getFloorNum()).cy("obj_id", this.iEZ.getThreadId()).aGx();
            }
            if (this.iEZ.aHI()) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13588");
                if (lVar.aDV() != null) {
                    anVar.cy("fid", lVar.aDV().getForumId());
                }
                anVar.cy("tid", lVar.getTid());
                anVar.cy("obj_param1", lVar.mRecomWeight);
                anVar.cy("obj_source", lVar.mRecomSource);
                anVar.X("obj_locate", lVar.getFloorNum());
                anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                anVar.cy("obj_id", this.iEZ.getThreadId());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (lVar.aAe().getBaijiahaoData() != null) {
                    anVar.cy("obj_param4", lVar.aAe().getBaijiahaoData().oriUgcNid);
                    anVar.cy("obj_param5", lVar.aAe().getBaijiahaoData().oriUgcVid);
                }
                anVar.X("obj_param6", lVar.aEk());
                anVar.cy(TiebaInitialize.Params.AB_TAG, lVar.mRecomAbTag);
                anVar.cy("extra", lVar.mRecomExtra);
                TiebaStatic.log(anVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.iEZ = eVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void pG(boolean z) {
        this.iFa = z;
    }
}
