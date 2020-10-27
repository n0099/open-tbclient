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
/* loaded from: classes22.dex */
public class h extends o<com.baidu.tbadk.core.data.n, i> {
    private int from;
    private com.baidu.tieba.pb.data.f lkO;
    private boolean lkP;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public i c(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lml.diC());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.jmk, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.lla, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.llc, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.bgh, R.color.cp_cont_b, 1, skinType);
                iVar.jwj.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lkY, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lld, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lle, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.b(iVar.kAe, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.bpo().oZ(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).pe(com.baidu.adp.lib.util.l.getDimens(this.lml.diC(), R.dimen.tbds10)).bg(iVar.lkW);
            }
            iVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.n nVar, i iVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tbadk.core.data.n) iVar);
        if (nVar == null) {
            return null;
        }
        a(iVar);
        iVar.a(nVar);
        iVar.setBjhFrom(this.from);
        iVar.tU(this.lkP);
        if (this.lkO != null) {
            iVar.Pf(this.lkO.getThreadId());
            iVar.tV(this.lkO.dgi());
            if (this.lkO.dfI() != null && this.lkO.dfI().getBaijiahaoData() != null) {
                iVar.setNid(this.lkO.dfI().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.BF("c13536").dR("tid", nVar.getTid()).w("fid", nVar.getFid()).aj("obj_source", i2).aj("obj_locate", nVar.getFloorNum()).dR("obj_id", this.lkO.getThreadId()).aj("obj_type", nVar.blU() ? 1 : 0).boK();
            } else {
                com.baidu.tbadk.core.util.aq.BF("c13533").dR("tid", nVar.getTid()).w("fid", nVar.getFid()).aj("obj_source", i2).aj("obj_locate", nVar.getFloorNum()).dR("obj_id", this.lkO.getThreadId()).boK();
            }
            if (this.lkO.dgi()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (nVar.blO() != null) {
                    aqVar.dR("fid", nVar.blO().getForumId());
                }
                aqVar.dR("tid", nVar.getTid());
                aqVar.dR("obj_param1", nVar.mRecomWeight);
                aqVar.dR("obj_source", nVar.mRecomSource);
                aqVar.aj("obj_locate", nVar.getFloorNum());
                aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dR("obj_id", this.lkO.getThreadId());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.bhz().getBaijiahaoData() != null) {
                    aqVar.dR("obj_param4", nVar.bhz().getBaijiahaoData().oriUgcNid);
                    aqVar.dR("obj_param5", nVar.bhz().getBaijiahaoData().oriUgcVid);
                }
                aqVar.aj("obj_param6", nVar.bma());
                aqVar.dR("ab_tag", nVar.mRecomAbTag);
                aqVar.dR("extra", nVar.mRecomExtra);
                TiebaStatic.log(aqVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lkO = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tU(boolean z) {
        this.lkP = z;
    }
}
