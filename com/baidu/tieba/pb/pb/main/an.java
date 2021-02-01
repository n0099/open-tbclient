package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class an extends com.baidu.tbadk.core.view.userLike.c {
    private cb akU;
    private String amC;
    public boolean isBigV;
    public boolean lYB;
    private int lYC;
    private int lYD;
    private TbPageContext mPageContext;

    public an(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.lYB = false;
        this.isBigV = false;
        this.lYC = 0;
        this.lYC = i;
        this.mPageContext = tbPageContext;
        if (this.lYC == 1) {
            super.Ag("4");
        } else if (this.lYC == 3) {
            super.Ag("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.Ag("4");
        } else {
            super.Ag("0");
        }
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    public void setTid(String str) {
        this.amC = str;
    }

    public void Ga(int i) {
        this.lYD = i;
    }

    private int dqc() {
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
            String userId = this.foy != null ? this.foy.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12408").ap("obj_source", dqc()).dR("obj_id", userId).dR("tid", this.amC));
            if (this.lYC != 1) {
                if (this.lYC == 3) {
                    i = 2;
                } else if (this.lYC == 5) {
                    i = 5;
                } else if (this.lYC == 7) {
                    i = 7;
                } else if (this.lYC == 6) {
                    i = 6;
                } else {
                    i = this.lYC == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12507");
            arVar.ap("obj_locate", i);
            arVar.dR("obj_id", userId);
            arVar.dR("tid", this.amC);
            arVar.ap("obj_param1", this.lYD);
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13570");
            arVar2.dR("obj_id", userId);
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar2.dR("tid", this.amC);
            if (this.akU != null) {
                arVar2.dR(IntentConfig.NID, this.akU.bmo());
                if (this.akU.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.akU.getBaijiahaoData().oriUgcVid)) {
                    arVar2.dR("obj_param6", this.akU.getBaijiahaoData().oriUgcVid);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, this.akU.mRecomSource);
                arVar2.dR("ab_tag", this.akU.mRecomAbTag);
                arVar2.dR("weight", this.akU.mRecomWeight);
                arVar2.dR("extra", this.akU.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar2);
            }
            TiebaStatic.log(arVar2);
            super.onClick(view);
            if (this.lYB && this.foy != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11924").dR("obj_id", this.foy.getUserId()));
            }
            if (this.isBigV && this.foy != null) {
                if (this.lYC == 1) {
                    i2 = 1;
                } else if (this.lYC != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12150").ap("obj_locate", i2).dR("obj_id", this.foy.getUserId()));
            }
        }
    }
}
