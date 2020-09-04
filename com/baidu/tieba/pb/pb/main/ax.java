package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes16.dex */
public class ax extends com.baidu.tbadk.core.view.userLike.c {
    private bw ajz;
    private String ala;
    public boolean isBigV;
    public boolean kKE;
    private int kKF;
    private int kKG;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.kKE = false;
        this.isBigV = false;
        this.kKF = 0;
        this.kKF = i;
        this.mPageContext = tbPageContext;
        if (this.kKF == 1) {
            super.zm("4");
        } else if (this.kKF == 3) {
            super.zm("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.zm("4");
        } else {
            super.zm("0");
        }
    }

    public void setThreadData(bw bwVar) {
        this.ajz = bwVar;
    }

    public void setTid(String str) {
        this.ala = str;
    }

    public void Et(int i) {
        this.kKG = i;
    }

    private int dah() {
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
            String userId = this.eyc != null ? this.eyc.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12408").ai("obj_source", dah()).dD("obj_id", userId).dD("tid", this.ala));
            if (this.kKF != 1) {
                if (this.kKF == 3) {
                    i = 2;
                } else if (this.kKF == 5) {
                    i = 5;
                } else if (this.kKF == 7) {
                    i = 7;
                } else if (this.kKF == 6) {
                    i = 6;
                } else {
                    i = this.kKF == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12507");
            aqVar.ai("obj_locate", i);
            aqVar.dD("obj_id", userId);
            aqVar.dD("tid", this.ala);
            aqVar.ai("obj_param1", this.kKG);
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13570");
            aqVar2.dD("obj_id", userId);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar2.dD("tid", this.ala);
            if (this.ajz != null) {
                aqVar2.dD("nid", this.ajz.getNid());
                if (this.ajz.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.ajz.getBaijiahaoData().oriUgcVid)) {
                    aqVar2.dD("obj_param6", this.ajz.getBaijiahaoData().oriUgcVid);
                }
                aqVar2.dD(IntentConfig.RECOM_SOURCE, this.ajz.mRecomSource);
                aqVar2.dD("ab_tag", this.ajz.mRecomAbTag);
                aqVar2.dD("weight", this.ajz.mRecomWeight);
                aqVar2.dD("extra", this.ajz.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar2);
            }
            TiebaStatic.log(aqVar2);
            super.onClick(view);
            if (this.kKE && this.eyc != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11924").dD("obj_id", this.eyc.getUserId()));
            }
            if (this.isBigV && this.eyc != null) {
                if (this.kKF == 1) {
                    i2 = 1;
                } else if (this.kKF != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12150").ai("obj_locate", i2).dD("obj_id", this.eyc.getUserId()));
            }
        }
    }
}
