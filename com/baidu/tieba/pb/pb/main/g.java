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
public class g extends l<com.baidu.tbadk.core.data.l, h> {
    private int from;
    private com.baidu.tieba.pb.data.e jqV;
    private boolean jqW;

    public g(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public h b(ViewGroup viewGroup) {
        h hVar = new h(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.jsa.cyk());
        a(hVar);
        return hVar;
    }

    private void a(h hVar) {
        if (hVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (hVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.hFn, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setBackgroundColor(hVar.jri, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrk, R.color.cp_link_tip_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.aJE, R.color.cp_cont_b, 1, skinType);
                hVar.jrf.setImageDrawable(SvgManager.aOU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrg, R.color.cp_cont_a, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrl, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.setViewTextColor(hVar.jrm, R.color.cp_cont_d, 1, skinType);
                com.baidu.tbadk.core.util.am.b(hVar.iKI, R.color.cp_bg_line_e, R.color.cp_bg_line_c, skinType);
                com.baidu.tbadk.core.util.e.a.aPu().kL(0).i(R.color.cp_bg_line_d_alpha0, R.color.cp_cont_b).kQ(com.baidu.adp.lib.util.l.getDimens(this.jsa.cyk(), R.dimen.tbds10)).aR(hVar.jrd);
            }
            hVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.l lVar, h hVar) {
        int i2 = 2;
        super.a(i, view, viewGroup, (ViewGroup) lVar, (com.baidu.tbadk.core.data.l) hVar);
        if (lVar == null) {
            return null;
        }
        a(hVar);
        hVar.a(lVar);
        hVar.setBjhFrom(this.from);
        hVar.qQ(this.jqW);
        if (this.jqV != null) {
            hVar.Hu(this.jqV.getThreadId());
            hVar.qR(this.jqV.aQh());
            if (this.jqV.cvu() != null && this.jqV.cvu().getBaijiahaoData() != null) {
                hVar.setNid(this.jqV.cvu().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (lVar.threadType == 40) {
                com.baidu.tbadk.core.util.an.uI("c13536").cI("tid", lVar.getTid()).t("fid", lVar.getFid()).af("obj_source", i2).af("obj_locate", lVar.getFloorNum()).cI("obj_id", this.jqV.getThreadId()).af("obj_type", lVar.aMx() ? 1 : 0).aOR();
            } else {
                com.baidu.tbadk.core.util.an.uI("c13533").cI("tid", lVar.getTid()).t("fid", lVar.getFid()).af("obj_source", i2).af("obj_locate", lVar.getFloorNum()).cI("obj_id", this.jqV.getThreadId()).aOR();
            }
            if (this.jqV.aQh()) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13588");
                if (lVar.aMp() != null) {
                    anVar.cI("fid", lVar.aMp().getForumId());
                }
                anVar.cI("tid", lVar.getTid());
                anVar.cI("obj_param1", lVar.mRecomWeight);
                anVar.cI("obj_source", lVar.mRecomSource);
                anVar.af("obj_locate", lVar.getFloorNum());
                anVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                anVar.cI("obj_id", this.jqV.getThreadId());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (lVar.aIw().getBaijiahaoData() != null) {
                    anVar.cI("obj_param4", lVar.aIw().getBaijiahaoData().oriUgcNid);
                    anVar.cI("obj_param5", lVar.aIw().getBaijiahaoData().oriUgcVid);
                }
                anVar.af("obj_param6", lVar.aME());
                anVar.cI(TiebaInitialize.Params.AB_TAG, lVar.mRecomAbTag);
                anVar.cI("extra", lVar.mRecomExtra);
                TiebaStatic.log(anVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.jqV = eVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void qQ(boolean z) {
        this.jqW = z;
    }
}
