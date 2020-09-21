package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes21.dex */
public class ax extends com.baidu.tbadk.core.view.userLike.c {
    private bw ajX;
    private String alA;
    public boolean isBigV;
    public boolean kTe;
    private int kTf;
    private int kTg;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.kTe = false;
        this.isBigV = false;
        this.kTf = 0;
        this.kTf = i;
        this.mPageContext = tbPageContext;
        if (this.kTf == 1) {
            super.zH("4");
        } else if (this.kTf == 3) {
            super.zH("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.zH("4");
        } else {
            super.zH("0");
        }
    }

    public void setThreadData(bw bwVar) {
        this.ajX = bwVar;
    }

    public void setTid(String str) {
        this.alA = str;
    }

    public void EU(int i) {
        this.kTg = i;
    }

    private int ddK() {
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
            String userId = this.eAi != null ? this.eAi.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12408").ai("obj_source", ddK()).dF("obj_id", userId).dF("tid", this.alA));
            if (this.kTf != 1) {
                if (this.kTf == 3) {
                    i = 2;
                } else if (this.kTf == 5) {
                    i = 5;
                } else if (this.kTf == 7) {
                    i = 7;
                } else if (this.kTf == 6) {
                    i = 6;
                } else {
                    i = this.kTf == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12507");
            aqVar.ai("obj_locate", i);
            aqVar.dF("obj_id", userId);
            aqVar.dF("tid", this.alA);
            aqVar.ai("obj_param1", this.kTg);
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13570");
            aqVar2.dF("obj_id", userId);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar2.dF("tid", this.alA);
            if (this.ajX != null) {
                aqVar2.dF("nid", this.ajX.getNid());
                if (this.ajX.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.ajX.getBaijiahaoData().oriUgcVid)) {
                    aqVar2.dF("obj_param6", this.ajX.getBaijiahaoData().oriUgcVid);
                }
                aqVar2.dF(IntentConfig.RECOM_SOURCE, this.ajX.mRecomSource);
                aqVar2.dF("ab_tag", this.ajX.mRecomAbTag);
                aqVar2.dF("weight", this.ajX.mRecomWeight);
                aqVar2.dF("extra", this.ajX.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar2);
            }
            TiebaStatic.log(aqVar2);
            super.onClick(view);
            if (this.kTe && this.eAi != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11924").dF("obj_id", this.eAi.getUserId()));
            }
            if (this.isBigV && this.eAi != null) {
                if (this.kTf == 1) {
                    i2 = 1;
                } else if (this.kTf != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12150").ai("obj_locate", i2).dF("obj_id", this.eAi.getUserId()));
            }
        }
    }
}
