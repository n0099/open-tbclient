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
public class h extends m<com.baidu.tbadk.core.data.k, i> {
    private int from;
    private com.baidu.tieba.pb.data.e jHO;
    private boolean jHP;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public i b(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.jJa.cFc());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(iVar.hUg, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setBackgroundColor(iVar.jIb, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(iVar.jId, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(iVar.aPv, R.color.cp_cont_b, 1, skinType);
                iVar.jHY.setImageDrawable(SvgManager.aUV().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.am.setViewTextColor(iVar.jHZ, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(iVar.jIe, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(iVar.jIf, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.b(iVar.iZM, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.aVv().ln(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).ls(com.baidu.adp.lib.util.l.getDimens(this.jJa.cFc(), R.dimen.tbds10)).aR(iVar.jHW);
            }
            iVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.k kVar, i iVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) kVar, (com.baidu.tbadk.core.data.k) iVar);
        if (kVar == null) {
            return null;
        }
        a(iVar);
        iVar.a(kVar);
        iVar.setBjhFrom(this.from);
        iVar.ro(this.jHP);
        if (this.jHO != null) {
            iVar.Ji(this.jHO.getThreadId());
            iVar.rp(this.jHO.aWi());
            if (this.jHO.cCi() != null && this.jHO.cCi().getBaijiahaoData() != null) {
                iVar.setNid(this.jHO.cCi().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (kVar.threadType == 40) {
                com.baidu.tbadk.core.util.an.wr("c13536").dh("tid", kVar.getTid()).s("fid", kVar.getFid()).ag("obj_source", i2).ag("obj_locate", kVar.getFloorNum()).dh("obj_id", this.jHO.getThreadId()).ag("obj_type", kVar.aSu() ? 1 : 0).aUS();
            } else {
                com.baidu.tbadk.core.util.an.wr("c13533").dh("tid", kVar.getTid()).s("fid", kVar.getFid()).ag("obj_source", i2).ag("obj_locate", kVar.getFloorNum()).dh("obj_id", this.jHO.getThreadId()).aUS();
            }
            if (this.jHO.aWi()) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13588");
                if (kVar.aSm() != null) {
                    anVar.dh("fid", kVar.aSm().getForumId());
                }
                anVar.dh("tid", kVar.getTid());
                anVar.dh("obj_param1", kVar.mRecomWeight);
                anVar.dh("obj_source", kVar.mRecomSource);
                anVar.ag("obj_locate", kVar.getFloorNum());
                anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                anVar.dh("obj_id", this.jHO.getThreadId());
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (kVar.aOi().getBaijiahaoData() != null) {
                    anVar.dh("obj_param4", kVar.aOi().getBaijiahaoData().oriUgcNid);
                    anVar.dh("obj_param5", kVar.aOi().getBaijiahaoData().oriUgcVid);
                }
                anVar.ag("obj_param6", kVar.aSB());
                anVar.dh("ab_tag", kVar.mRecomAbTag);
                anVar.dh("extra", kVar.mRecomExtra);
                TiebaStatic.log(anVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jHO = eVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void ro(boolean z) {
        this.jHP = z;
    }
}
