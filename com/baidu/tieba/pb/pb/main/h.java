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
    private com.baidu.tieba.pb.data.f kYp;
    private boolean kYq;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public i c(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.kZM.dfv());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.iZQ, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.kYB, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kYD, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.beR, R.color.cp_cont_b, 1, skinType);
                iVar.jjM.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kYz, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kYE, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.kYF, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ap.b(iVar.knH, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.bnv().oO(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).oT(com.baidu.adp.lib.util.l.getDimens(this.kZM.dfv(), R.dimen.tbds10)).bf(iVar.kYx);
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
        iVar.tD(this.kYq);
        if (this.kYp != null) {
            iVar.OH(this.kYp.getThreadId());
            iVar.tE(this.kYp.dda());
            if (this.kYp.dcA() != null && this.kYp.dcA().getBaijiahaoData() != null) {
                iVar.setNid(this.kYp.dcA().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.aq.Bm("c13536").dK("tid", nVar.getTid()).u("fid", nVar.getFid()).aj("obj_source", i2).aj("obj_locate", nVar.getFloorNum()).dK("obj_id", this.kYp.getThreadId()).aj("obj_type", nVar.bkb() ? 1 : 0).bmR();
            } else {
                com.baidu.tbadk.core.util.aq.Bm("c13533").dK("tid", nVar.getTid()).u("fid", nVar.getFid()).aj("obj_source", i2).aj("obj_locate", nVar.getFloorNum()).dK("obj_id", this.kYp.getThreadId()).bmR();
            }
            if (this.kYp.dda()) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13588");
                if (nVar.bjV() != null) {
                    aqVar.dK("fid", nVar.bjV().getForumId());
                }
                aqVar.dK("tid", nVar.getTid());
                aqVar.dK("obj_param1", nVar.mRecomWeight);
                aqVar.dK("obj_source", nVar.mRecomSource);
                aqVar.aj("obj_locate", nVar.getFloorNum());
                aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aqVar.dK("obj_id", this.kYp.getThreadId());
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.bfG().getBaijiahaoData() != null) {
                    aqVar.dK("obj_param4", nVar.bfG().getBaijiahaoData().oriUgcNid);
                    aqVar.dK("obj_param5", nVar.bfG().getBaijiahaoData().oriUgcVid);
                }
                aqVar.aj("obj_param6", nVar.bkh());
                aqVar.dK("ab_tag", nVar.mRecomAbTag);
                aqVar.dK("extra", nVar.mRecomExtra);
                TiebaStatic.log(aqVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.kYp = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tD(boolean z) {
        this.kYq = z;
    }
}
