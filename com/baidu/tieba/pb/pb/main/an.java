package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class an extends com.baidu.tbadk.core.view.userLike.c {
    private bz ale;
    private String amM;
    public boolean isBigV;
    public boolean lPF;
    private int lPG;
    private int lPH;
    private TbPageContext mPageContext;

    public an(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.lPF = false;
        this.isBigV = false;
        this.lPG = 0;
        this.lPG = i;
        this.mPageContext = tbPageContext;
        if (this.lPG == 1) {
            super.zP("4");
        } else if (this.lPG == 3) {
            super.zP("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.zP("4");
        } else {
            super.zP("0");
        }
    }

    public void setThreadData(bz bzVar) {
        this.ale = bzVar;
    }

    public void setTid(String str) {
        this.amM = str;
    }

    public void FH(int i) {
        this.lPH = i;
    }

    private int dnO() {
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
            String userId = this.fmf != null ? this.fmf.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12408").an("obj_source", dnO()).dW("obj_id", userId).dW("tid", this.amM));
            if (this.lPG != 1) {
                if (this.lPG == 3) {
                    i = 2;
                } else if (this.lPG == 5) {
                    i = 5;
                } else if (this.lPG == 7) {
                    i = 7;
                } else if (this.lPG == 6) {
                    i = 6;
                } else {
                    i = this.lPG == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12507");
            aqVar.an("obj_locate", i);
            aqVar.dW("obj_id", userId);
            aqVar.dW("tid", this.amM);
            aqVar.an("obj_param1", this.lPH);
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13570");
            aqVar2.dW("obj_id", userId);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar2.dW("tid", this.amM);
            if (this.ale != null) {
                aqVar2.dW(IntentConfig.NID, this.ale.blV());
                if (this.ale.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.ale.getBaijiahaoData().oriUgcVid)) {
                    aqVar2.dW("obj_param6", this.ale.getBaijiahaoData().oriUgcVid);
                }
                aqVar2.dW(IntentConfig.RECOM_SOURCE, this.ale.mRecomSource);
                aqVar2.dW("ab_tag", this.ale.mRecomAbTag);
                aqVar2.dW("weight", this.ale.mRecomWeight);
                aqVar2.dW("extra", this.ale.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar2);
            }
            TiebaStatic.log(aqVar2);
            super.onClick(view);
            if (this.lPF && this.fmf != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11924").dW("obj_id", this.fmf.getUserId()));
            }
            if (this.isBigV && this.fmf != null) {
                if (this.lPG == 1) {
                    i2 = 1;
                } else if (this.lPG != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12150").an("obj_locate", i2).dW("obj_id", this.fmf.getUserId()));
            }
        }
    }
}
