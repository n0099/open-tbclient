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
/* loaded from: classes21.dex */
public class h extends o<com.baidu.tbadk.core.data.n, i> {
    private int from;
    private com.baidu.tieba.pb.data.f kJe;
    private boolean kJf;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cb */
    public i c(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.kKB.dbM());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.iKY, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.kJq, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kJs, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.bbh, R.color.cp_cont_b, 1, skinType);
                iVar.iUO.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kJo, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kJt, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kJu, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.b(iVar.jYr, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.bkL().oq(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).ov(com.baidu.adp.lib.util.l.getDimens(this.kKB.dbM(), R.dimen.tbds10)).bb(iVar.kJm);
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
        iVar.sW(this.kJf);
        if (this.kJe != null) {
            iVar.NS(this.kJe.getThreadId());
            iVar.sX(this.kJe.cZr());
            if (this.kJe.cYR() != null && this.kJe.cYR().getBaijiahaoData() != null) {
                iVar.setNid(this.kJe.cYR().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.AA("c13536").dF("tid", nVar.getTid()).u("fid", nVar.getFid()).ai("obj_source", i2).ai("obj_locate", nVar.getFloorNum()).dF("obj_id", this.kJe.getThreadId()).ai("obj_type", nVar.bhs() ? 1 : 0).bki();
            } else {
                com.baidu.tbadk.core.util.aq.AA("c13533").dF("tid", nVar.getTid()).u("fid", nVar.getFid()).ai("obj_source", i2).ai("obj_locate", nVar.getFloorNum()).dF("obj_id", this.kJe.getThreadId()).bki();
            }
            if (this.kJe.cZr()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (nVar.bhm() != null) {
                    aqVar.dF("fid", nVar.bhm().getForumId());
                }
                aqVar.dF("tid", nVar.getTid());
                aqVar.dF("obj_param1", nVar.mRecomWeight);
                aqVar.dF("obj_source", nVar.mRecomSource);
                aqVar.ai("obj_locate", nVar.getFloorNum());
                aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dF("obj_id", this.kJe.getThreadId());
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.bcY().getBaijiahaoData() != null) {
                    aqVar.dF("obj_param4", nVar.bcY().getBaijiahaoData().oriUgcNid);
                    aqVar.dF("obj_param5", nVar.bcY().getBaijiahaoData().oriUgcVid);
                }
                aqVar.ai("obj_param6", nVar.bhy());
                aqVar.dF("ab_tag", nVar.mRecomAbTag);
                aqVar.dF("extra", nVar.mRecomExtra);
                TiebaStatic.log(aqVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kJe = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void sW(boolean z) {
        this.kJf = z;
    }
}
