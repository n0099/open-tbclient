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
    private bw ajx;
    private String akY;
    public boolean isBigV;
    public boolean kKx;
    private int kKy;
    private int kKz;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.kKx = false;
        this.isBigV = false;
        this.kKy = 0;
        this.kKy = i;
        this.mPageContext = tbPageContext;
        if (this.kKy == 1) {
            super.zl("4");
        } else if (this.kKy == 3) {
            super.zl("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.zl("4");
        } else {
            super.zl("0");
        }
    }

    public void setThreadData(bw bwVar) {
        this.ajx = bwVar;
    }

    public void setTid(String str) {
        this.akY = str;
    }

    public void Et(int i) {
        this.kKz = i;
    }

    private int dag() {
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
            String userId = this.exY != null ? this.exY.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12408").ai("obj_source", dag()).dD("obj_id", userId).dD("tid", this.akY));
            if (this.kKy != 1) {
                if (this.kKy == 3) {
                    i = 2;
                } else if (this.kKy == 5) {
                    i = 5;
                } else if (this.kKy == 7) {
                    i = 7;
                } else if (this.kKy == 6) {
                    i = 6;
                } else {
                    i = this.kKy == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12507");
            aqVar.ai("obj_locate", i);
            aqVar.dD("obj_id", userId);
            aqVar.dD("tid", this.akY);
            aqVar.ai("obj_param1", this.kKz);
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13570");
            aqVar2.dD("obj_id", userId);
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar2.dD("tid", this.akY);
            if (this.ajx != null) {
                aqVar2.dD("nid", this.ajx.getNid());
                if (this.ajx.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.ajx.getBaijiahaoData().oriUgcVid)) {
                    aqVar2.dD("obj_param6", this.ajx.getBaijiahaoData().oriUgcVid);
                }
                aqVar2.dD(IntentConfig.RECOM_SOURCE, this.ajx.mRecomSource);
                aqVar2.dD("ab_tag", this.ajx.mRecomAbTag);
                aqVar2.dD("weight", this.ajx.mRecomWeight);
                aqVar2.dD("extra", this.ajx.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar2);
            }
            TiebaStatic.log(aqVar2);
            super.onClick(view);
            if (this.kKx && this.exY != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11924").dD("obj_id", this.exY.getUserId()));
            }
            if (this.isBigV && this.exY != null) {
                if (this.kKy == 1) {
                    i2 = 1;
                } else if (this.kKy != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12150").ai("obj_locate", i2).dD("obj_id", this.exY.getUserId()));
            }
        }
    }
}
