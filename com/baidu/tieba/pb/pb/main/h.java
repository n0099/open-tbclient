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
    private com.baidu.tieba.pb.data.f lqP;
    private boolean lqQ;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public i c(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lsm.dle());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.jsi, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.lrb, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lrd, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.bhB, R.color.cp_cont_b, 1, skinType);
                iVar.jCg.setImageDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lqZ, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lre, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lrf, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.b(iVar.kFY, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.brO().pj(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).pp(com.baidu.adp.lib.util.l.getDimens(this.lsm.dle(), R.dimen.tbds10)).bk(iVar.lqX);
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
        iVar.ud(this.lqQ);
        if (this.lqP != null) {
            iVar.Pw(this.lqP.getThreadId());
            iVar.ue(this.lqP.diK());
            if (this.lqP.dik() != null && this.lqP.dik().getBaijiahaoData() != null) {
                iVar.setNid(this.lqP.dik().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.BT("c13536").dR("tid", nVar.getTid()).w("fid", nVar.getFid()).al("obj_source", i2).al("obj_locate", nVar.getFloorNum()).dR("obj_id", this.lqP.getThreadId()).al("obj_type", nVar.bou() ? 1 : 0).brk();
            } else {
                com.baidu.tbadk.core.util.aq.BT("c13533").dR("tid", nVar.getTid()).w("fid", nVar.getFid()).al("obj_source", i2).al("obj_locate", nVar.getFloorNum()).dR("obj_id", this.lqP.getThreadId()).brk();
            }
            if (this.lqP.diK()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (nVar.boo() != null) {
                    aqVar.dR("fid", nVar.boo().getForumId());
                }
                aqVar.dR("tid", nVar.getTid());
                aqVar.dR("obj_param1", nVar.mRecomWeight);
                aqVar.dR("obj_source", nVar.mRecomSource);
                aqVar.al("obj_locate", nVar.getFloorNum());
                aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dR("obj_id", this.lqP.getThreadId());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.bjZ().getBaijiahaoData() != null) {
                    aqVar.dR("obj_param4", nVar.bjZ().getBaijiahaoData().oriUgcNid);
                    aqVar.dR("obj_param5", nVar.bjZ().getBaijiahaoData().oriUgcVid);
                }
                aqVar.al("obj_param6", nVar.boA());
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
        this.lqP = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void ud(boolean z) {
        this.lqQ = z;
    }
}
