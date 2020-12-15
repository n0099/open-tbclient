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
public class h extends o<com.baidu.tbadk.core.data.o, i> {
    private int from;
    private com.baidu.tieba.pb.data.f lEP;
    private boolean lEQ;

    public h(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public i c(ViewGroup viewGroup) {
        i iVar = new i(LayoutInflater.from(this.mContext).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.lGq.dpR());
        a(iVar);
        return iVar;
    }

    private void a(i iVar) {
        if (iVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (iVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.jGr, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.fzY, R.color.CAM_X0203, skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(iVar.lFb, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lFd, R.color.CAM_X0302, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.bkf, R.color.CAM_X0105, 1, skinType);
                iVar.jQH.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lEZ, R.color.CAM_X0101, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lFe, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.setViewTextColor(iVar.lFf, R.color.CAM_X0109, 1, skinType);
                com.baidu.tbadk.core.util.ap.c(iVar.kTH, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
                com.baidu.tbadk.core.util.e.a.buz().qf(0).l(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).qm(com.baidu.adp.lib.util.l.getDimens(this.lGq.dpR(), R.dimen.tbds10)).bq(iVar.lEX);
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
        iVar.uI(this.lEQ);
        if (this.lEP != null) {
            iVar.Qa(this.lEP.getThreadId());
            iVar.uJ(this.lEP.dnv());
            if (this.lEP.dmU() != null && this.lEP.dmU().getBaijiahaoData() != null) {
                iVar.setNid(this.lEP.dmU().getBaijiahaoData().oriUgcNid);
            }
            if (this.from == 2) {
                i2 = 1;
            } else if (this.from != 1) {
                i2 = this.from == 3 ? 3 : 4;
            }
            if (oVar.threadType == 40) {
                com.baidu.tbadk.core.util.ar.BZ("c13536").dY("tid", oVar.getTid()).w("fid", oVar.getFid()).al("obj_source", i2).al("obj_locate", oVar.getFloorNum()).dY("obj_id", this.lEP.getThreadId()).al("obj_type", oVar.bqL() ? 1 : 0).btT();
            } else {
                com.baidu.tbadk.core.util.ar.BZ("c13533").dY("tid", oVar.getTid()).w("fid", oVar.getFid()).al("obj_source", i2).al("obj_locate", oVar.getFloorNum()).dY("obj_id", this.lEP.getThreadId()).btT();
            }
            if (this.lEP.dnv()) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13588");
                if (oVar.bqF() != null) {
                    arVar.dY("fid", oVar.bqF().getForumId());
                }
                arVar.dY("tid", oVar.getTid());
                arVar.dY("obj_param1", oVar.mRecomWeight);
                arVar.dY("obj_source", oVar.mRecomSource);
                arVar.al("obj_locate", oVar.getFloorNum());
                arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
                arVar.dY("obj_id", this.lEP.getThreadId());
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (oVar.bmn().getBaijiahaoData() != null) {
                    arVar.dY("obj_param4", oVar.bmn().getBaijiahaoData().oriUgcNid);
                    arVar.dY("obj_param5", oVar.bmn().getBaijiahaoData().oriUgcVid);
                }
                arVar.al("obj_param6", oVar.bqR());
                arVar.dY("ab_tag", oVar.mRecomAbTag);
                arVar.dY("extra", oVar.mRecomExtra);
                TiebaStatic.log(arVar);
                return view;
            }
            return view;
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.lEP = fVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uI(boolean z) {
        this.lEQ = z;
    }
}
