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
/* loaded from: classes16.dex */
public class h extends o<com.baidu.tbadk.core.data.n, i> {
    private int from;
    private com.baidu.tieba.pb.data.f kAA;
    private boolean kAB;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ca */
    public i b(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.kBW.cYi());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.iDx, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.kAM, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kAO, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.aYI, R.color.cp_cont_b, 1, skinType);
                iVar.iMc.setImageDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kAK, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kAP, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kAQ, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.b(iVar.jPI, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).oj(com.baidu.adp.lib.util.l.getDimens(this.kBW.cYi(), R.dimen.tbds10)).aZ(iVar.kAI);
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
        iVar.sN(this.kAB);
        if (this.kAA != null) {
            iVar.Nq(this.kAA.getThreadId());
            iVar.sO(this.kAA.cVL());
            if (this.kAA.cVl() != null && this.kAA.cVl().getBaijiahaoData() != null) {
                iVar.setNid(this.kAA.cVl().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.Ad("c13536").dD("tid", nVar.getTid()).u("fid", nVar.getFid()).ai("obj_source", i2).ai("obj_locate", nVar.getFloorNum()).dD("obj_id", this.kAA.getThreadId()).ai("obj_type", nVar.bgy() ? 1 : 0).bjn();
            } else {
                com.baidu.tbadk.core.util.aq.Ad("c13533").dD("tid", nVar.getTid()).u("fid", nVar.getFid()).ai("obj_source", i2).ai("obj_locate", nVar.getFloorNum()).dD("obj_id", this.kAA.getThreadId()).bjn();
            }
            if (this.kAA.cVL()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (nVar.bgs() != null) {
                    aqVar.dD("fid", nVar.bgs().getForumId());
                }
                aqVar.dD("tid", nVar.getTid());
                aqVar.dD("obj_param1", nVar.mRecomWeight);
                aqVar.dD("obj_source", nVar.mRecomSource);
                aqVar.ai("obj_locate", nVar.getFloorNum());
                aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dD("obj_id", this.kAA.getThreadId());
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.bce().getBaijiahaoData() != null) {
                    aqVar.dD("obj_param4", nVar.bce().getBaijiahaoData().oriUgcNid);
                    aqVar.dD("obj_param5", nVar.bce().getBaijiahaoData().oriUgcVid);
                }
                aqVar.ai("obj_param6", nVar.bgE());
                aqVar.dD("ab_tag", nVar.mRecomAbTag);
                aqVar.dD("extra", nVar.mRecomExtra);
                TiebaStatic.log(aqVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kAA = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void sN(boolean z) {
        this.kAB = z;
    }
}
