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
    private com.baidu.tieba.pb.data.f kli;
    private boolean klj;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public i b(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.kmE.cNt());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(iVar.ipt, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(iVar.klu, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.klw, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.aTu, R.color.cp_cont_b, 1, skinType);
                iVar.ixr.setImageDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.kls, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.klx, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ao.setViewTextColor(iVar.kly, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.ao.b(iVar.jAo, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.bbr().ma(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).mf(com.baidu.adp.lib.util.l.getDimens(this.kmE.cNt(), R.dimen.tbds10)).aX(iVar.klq);
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
        iVar.sg(this.klj);
        if (this.kli != null) {
            iVar.Kx(this.kli.getThreadId());
            iVar.sh(this.kli.cKX());
            if (this.kli.cKx() != null && this.kli.cKx().getBaijiahaoData() != null) {
                iVar.setNid(this.kli.cKx().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.ap.xP("c13536").dn("tid", nVar.getTid()).t("fid", nVar.getFid()).ah("obj_source", i2).ah("obj_locate", nVar.getFloorNum()).dn("obj_id", this.kli.getThreadId()).ah("obj_type", nVar.aYf() ? 1 : 0).baO();
            } else {
                com.baidu.tbadk.core.util.ap.xP("c13533").dn("tid", nVar.getTid()).t("fid", nVar.getFid()).ah("obj_source", i2).ah("obj_locate", nVar.getFloorNum()).dn("obj_id", this.kli.getThreadId()).baO();
            }
            if (this.kli.cKX()) {
                com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13588");
                if (nVar.aXZ() != null) {
                    apVar.dn("fid", nVar.aXZ().getForumId());
                }
                apVar.dn("tid", nVar.getTid());
                apVar.dn("obj_param1", nVar.mRecomWeight);
                apVar.dn("obj_source", nVar.mRecomSource);
                apVar.ah("obj_locate", nVar.getFloorNum());
                apVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                apVar.dn("obj_id", this.kli.getThreadId());
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
        this.kli = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void sg(boolean z) {
        this.klj = z;
    }
}
