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
public class h extends o<com.baidu.tbadk.core.data.o, i> {
    private int from;
    private com.baidu.tieba.pb.data.f lre;
    private boolean lrf;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public i c(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lsC.dkB());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.jsP, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.fsk, R.color.CAM_X0203, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.lrq, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lrs, R.color.CAM_X0302, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.bfP, R.color.CAM_X0105, 1, skinType);
                iVar.jDd.setImageDrawable(SvgManager.bqB().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lro, R.color.CAM_X0101, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lrt, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lru, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.b(iVar.kGn, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.e.a.brc().pF(0).l(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).pM(com.baidu.adp.lib.util.l.getDimens(this.lsC.dkB(), R.dimen.tbds10)).bn(iVar.lrm);
            }
            iVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.o oVar, i iVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tbadk.core.data.o) iVar);
        if (oVar == null) {
            return null;
        }
        a(iVar);
        iVar.a(oVar);
        iVar.setBjhFrom(this.from);
        iVar.ug(this.lrf);
        if (this.lre != null) {
            iVar.OS(this.lre.getThreadId());
            iVar.uh(this.lre.dih());
            if (this.lre.dhH() != null && this.lre.dhH().getBaijiahaoData() != null) {
                iVar.setNid(this.lre.dhH().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (oVar.threadType == 40) {
                com.baidu.tbadk.core.util.ar.Bs("c13536").dR("tid", oVar.getTid()).w("fid", oVar.getFid()).ak("obj_source", i2).ak("obj_locate", oVar.getFloorNum()).dR("obj_id", this.lre.getThreadId()).ak("obj_type", oVar.bny() ? 1 : 0).bqy();
            } else {
                com.baidu.tbadk.core.util.ar.Bs("c13533").dR("tid", oVar.getTid()).w("fid", oVar.getFid()).ak("obj_source", i2).ak("obj_locate", oVar.getFloorNum()).dR("obj_id", this.lre.getThreadId()).bqy();
            }
            if (this.lre.dih()) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13588");
                if (oVar.bns() != null) {
                    arVar.dR("fid", oVar.bns().getForumId());
                }
                arVar.dR("tid", oVar.getTid());
                arVar.dR("obj_param1", oVar.mRecomWeight);
                arVar.dR("obj_source", oVar.mRecomSource);
                arVar.ak("obj_locate", oVar.getFloorNum());
                arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                arVar.dR("obj_id", this.lre.getThreadId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (oVar.bjd().getBaijiahaoData() != null) {
                    arVar.dR("obj_param4", oVar.bjd().getBaijiahaoData().oriUgcNid);
                    arVar.dR("obj_param5", oVar.bjd().getBaijiahaoData().oriUgcVid);
                }
                arVar.ak("obj_param6", oVar.bnE());
                arVar.dR("ab_tag", oVar.mRecomAbTag);
                arVar.dR("extra", oVar.mRecomExtra);
                TiebaStatic.log(arVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lre = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void ug(boolean z) {
        this.lrf = z;
    }
}
