package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes22.dex */
public class ax extends com.baidu.tbadk.core.view.userLike.c {
    private bw akq;
    private String alT;
    public boolean isBigV;
    public boolean luU;
    private int luV;
    private int luW;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.luU = false;
        this.isBigV = false;
        this.luV = 0;
        this.luV = i;
        this.mPageContext = tbPageContext;
        if (this.luV == 1) {
            super.AM("4");
        } else if (this.luV == 3) {
            super.AM("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.AM("4");
        } else {
            super.AM("0");
        }
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public void setTid(String str) {
        this.alT = str;
    }

    public void FT(int i) {
        this.luW = i;
    }

    private int dkA() {
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
            String userId = this.eUL != null ? this.eUL.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12408").aj("obj_source", dkA()).dR("obj_id", userId).dR("tid", this.alT));
            if (this.luV != 1) {
                if (this.luV == 3) {
                    i = 2;
                } else if (this.luV == 5) {
                    i = 5;
                } else if (this.luV == 7) {
                    i = 7;
                } else if (this.luV == 6) {
                    i = 6;
                } else {
                    i = this.luV == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12507");
            aqVar.aj("obj_locate", i);
            aqVar.dR("obj_id", userId);
            aqVar.dR("tid", this.alT);
            aqVar.aj("obj_param1", this.luW);
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13570");
            aqVar2.dR("obj_id", userId);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar2.dR("tid", this.alT);
            if (this.akq != null) {
                aqVar2.dR("nid", this.akq.getNid());
                if (this.akq.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.akq.getBaijiahaoData().oriUgcVid)) {
                    aqVar2.dR("obj_param6", this.akq.getBaijiahaoData().oriUgcVid);
                }
                aqVar2.dR(IntentConfig.RECOM_SOURCE, this.akq.mRecomSource);
                aqVar2.dR("ab_tag", this.akq.mRecomAbTag);
                aqVar2.dR("weight", this.akq.mRecomWeight);
                aqVar2.dR("extra", this.akq.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar2);
            }
            TiebaStatic.log(aqVar2);
            super.onClick(view);
            if (this.luU && this.eUL != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11924").dR("obj_id", this.eUL.getUserId()));
            }
            if (this.isBigV && this.eUL != null) {
                if (this.luV == 1) {
                    i2 = 1;
                } else if (this.luV != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12150").aj("obj_locate", i2).dR("obj_id", this.eUL.getUserId()));
            }
        }
    }
}
