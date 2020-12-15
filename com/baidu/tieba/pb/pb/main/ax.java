package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes22.dex */
public class ax extends com.baidu.tbadk.core.view.userLike.c {
    private by alu;
    private String amY;
    public boolean isBigV;
    public boolean lOY;
    private int lOZ;
    private int lPa;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.lOY = false;
        this.isBigV = false;
        this.lOZ = 0;
        this.lOZ = i;
        this.mPageContext = tbPageContext;
        if (this.lOZ == 1) {
            super.Bc("4");
        } else if (this.lOZ == 3) {
            super.Bc("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.Bc("4");
        } else {
            super.Bc("0");
        }
    }

    public void setThreadData(by byVar) {
        this.alu = byVar;
    }

    public void setTid(String str) {
        this.amY = str;
    }

    public void Hu(int i) {
        this.lPa = i;
    }

    private int drT() {
        String fromPageKey = UtilHelper.getFromPageKey(this.mPageContext);
        if (fromPageKey == null) {
            return 3;
        }
        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_CONCERN)) {
            return 1;
        }
        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE)) {
            return 2;
        }
        if (fromPageKey.equals(PageStayDurationConstants.PageName.FRS)) {
            return 3;
        }
        if (fromPageKey.equals(PageStayDurationConstants.PageName.PERSON)) {
            return 4;
        }
        if (fromPageKey.equals(PageStayDurationConstants.PageName.DISCOVER)) {
            return 5;
        }
        if (fromPageKey.equals(PageStayDurationConstants.PageName.HOT_TOPIC)) {
            return 6;
        }
        return 7;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 3;
        int i2 = 2;
        if (view != null && view.getAlpha() >= 0.4d) {
            String userId = this.fhf != null ? this.fhf.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12408").al("obj_source", drT()).dY("obj_id", userId).dY("tid", this.amY));
            if (this.lOZ != 1) {
                if (this.lOZ == 3) {
                    i = 2;
                } else if (this.lOZ == 5) {
                    i = 5;
                } else if (this.lOZ == 7) {
                    i = 7;
                } else if (this.lOZ == 6) {
                    i = 6;
                } else {
                    i = this.lOZ == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12507");
            arVar.al("obj_locate", i);
            arVar.dY("obj_id", userId);
            arVar.dY("tid", this.amY);
            arVar.al("obj_param1", this.lPa);
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13570");
            arVar2.dY("obj_id", userId);
            arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar2.dY("tid", this.amY);
            if (this.alu != null) {
                arVar2.dY("nid", this.alu.getNid());
                if (this.alu.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.alu.getBaijiahaoData().oriUgcVid)) {
                    arVar2.dY("obj_param6", this.alu.getBaijiahaoData().oriUgcVid);
                }
                arVar2.dY(IntentConfig.RECOM_SOURCE, this.alu.mRecomSource);
                arVar2.dY("ab_tag", this.alu.mRecomAbTag);
                arVar2.dY("weight", this.alu.mRecomWeight);
                arVar2.dY("extra", this.alu.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar2);
            }
            TiebaStatic.log(arVar2);
            super.onClick(view);
            if (this.lOY && this.fhf != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11924").dY("obj_id", this.fhf.getUserId()));
            }
            if (this.isBigV && this.fhf != null) {
                if (this.lOZ == 1) {
                    i2 = 1;
                } else if (this.lOZ != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12150").al("obj_locate", i2).dY("obj_id", this.fhf.getUserId()));
            }
        }
    }
}
