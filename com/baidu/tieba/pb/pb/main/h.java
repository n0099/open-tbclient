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
    private com.baidu.tieba.pb.data.f klg;
    private boolean klh;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public i b(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.kmC.cNt());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(iVar.ipr, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(iVar.kls, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.klu, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.aTu, R.color.cp_cont_b, 1, skinType);
                iVar.ixp.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.klq, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.klv, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.klw, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ao.b(iVar.jAm, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).mf(com.baidu.adp.lib.util.l.getDimens(this.kmC.cNt(), R.dimen.tbds10)).aX(iVar.klo);
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
        iVar.sg(this.klh);
        if (this.klg != null) {
            iVar.Kx(this.klg.getThreadId());
            iVar.sh(this.klg.cKX());
            if (this.klg.cKx() != null && this.klg.cKx().getBaijiahaoData() != null) {
                iVar.setNid(this.klg.cKx().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.ap.xP("c13536").dn("tid", nVar.getTid()).t("fid", nVar.getFid()).ah("obj_source", i2).ah("obj_locate", nVar.getFloorNum()).dn("obj_id", this.klg.getThreadId()).ah("obj_type", nVar.aYf() ? 1 : 0).baO();
            } else {
                com.baidu.tbadk.core.util.ap.xP("c13533").dn("tid", nVar.getTid()).t("fid", nVar.getFid()).ah("obj_source", i2).ah("obj_locate", nVar.getFloorNum()).dn("obj_id", this.klg.getThreadId()).baO();
            }
            if (this.klg.cKX()) {
                com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13588");
                if (nVar.aXZ() != null) {
                    apVar.dn("fid", nVar.aXZ().getForumId());
                }
                apVar.dn("tid", nVar.getTid());
                apVar.dn("obj_param1", nVar.mRecomWeight);
                apVar.dn("obj_source", nVar.mRecomSource);
                apVar.ah("obj_locate", nVar.getFloorNum());
                apVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                apVar.dn("obj_id", this.klg.getThreadId());
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.aTN().getBaijiahaoData() != null) {
                    apVar.dn("obj_param4", nVar.aTN().getBaijiahaoData().oriUgcNid);
                    apVar.dn("obj_param5", nVar.aTN().getBaijiahaoData().oriUgcVid);
                }
                apVar.ah("obj_param6", nVar.aYl());
                apVar.dn("ab_tag", nVar.mRecomAbTag);
                apVar.dn("extra", nVar.mRecomExtra);
                TiebaStatic.log(apVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.klg = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void sg(boolean z) {
        this.klh = z;
    }
}
