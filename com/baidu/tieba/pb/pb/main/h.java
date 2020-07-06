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
public class h extends m<com.baidu.tbadk.core.data.n, i> {
    private int from;
    private com.baidu.tieba.pb.data.e kcE;
    private boolean kcF;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public i b(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.kdO.cJJ());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.an.setBackgroundColor(iVar.ijo, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.an.setBackgroundColor(iVar.kcQ, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.an.setViewTextColor(iVar.kcS, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.an.setViewTextColor(iVar.aSb, R.color.cp_cont_b, 1, skinType);
                iVar.irl.setImageDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.an.setViewTextColor(iVar.kcO, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.an.setViewTextColor(iVar.kcT, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.an.setViewTextColor(iVar.kcU, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.an.b(iVar.jrJ, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.aXq().lG(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).lL(com.baidu.adp.lib.util.l.getDimens(this.kdO.cJJ(), R.dimen.tbds10)).aR(iVar.kcM);
            }
            iVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.n nVar, i iVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tbadk.core.data.n) iVar);
        if (nVar == null) {
            return null;
        }
        a(iVar);
        iVar.a(nVar);
        iVar.setBjhFrom(this.from);
        iVar.rB(this.kcF);
        if (this.kcE != null) {
            iVar.JL(this.kcE.getThreadId());
            iVar.rC(this.kcE.cHn());
            if (this.kcE.cGO() != null && this.kcE.cGO().getBaijiahaoData() != null) {
                iVar.setNid(this.kcE.cGO().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (nVar.threadType == 40) {
                com.baidu.tbadk.core.util.ao.wH("c13536").dk("tid", nVar.getTid()).s("fid", nVar.getFid()).ag("obj_source", i2).ag("obj_locate", nVar.getFloorNum()).dk("obj_id", this.kcE.getThreadId()).ag("obj_type", nVar.aUk() ? 1 : 0).aWN();
            } else {
                com.baidu.tbadk.core.util.ao.wH("c13533").dk("tid", nVar.getTid()).s("fid", nVar.getFid()).ag("obj_source", i2).ag("obj_locate", nVar.getFloorNum()).dk("obj_id", this.kcE.getThreadId()).aWN();
            }
            if (this.kcE.cHn()) {
                com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13588");
                if (nVar.aUd() != null) {
                    aoVar.dk("fid", nVar.aUd().getForumId());
                }
                aoVar.dk("tid", nVar.getTid());
                aoVar.dk("obj_param1", nVar.mRecomWeight);
                aoVar.dk("obj_source", nVar.mRecomSource);
                aoVar.ag("obj_locate", nVar.getFloorNum());
                aoVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                aoVar.dk("obj_id", this.kcE.getThreadId());
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                if (nVar.aPS().getBaijiahaoData() != null) {
                    aoVar.dk("obj_param4", nVar.aPS().getBaijiahaoData().oriUgcNid);
                    aoVar.dk("obj_param5", nVar.aPS().getBaijiahaoData().oriUgcVid);
                }
                aoVar.ag("obj_param6", nVar.aUq());
                aoVar.dk("ab_tag", nVar.mRecomAbTag);
                aoVar.dk("extra", nVar.mRecomExtra);
                TiebaStatic.log(aoVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.kcE = eVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void rB(boolean z) {
        this.kcF = z;
    }
}
