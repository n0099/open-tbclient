package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes9.dex */
public class at extends com.baidu.tbadk.core.view.userLike.c {
    private bu aiq;
    private String ajO;
    public boolean isBigV;
    public boolean klT;
    private int klU;
    private int klV;
    private TbPageContext mPageContext;

    public at(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.klT = false;
        this.isBigV = false;
        this.klU = 0;
        this.klU = i;
        this.mPageContext = tbPageContext;
        if (this.klU == 1) {
            super.vQ("4");
        } else if (this.klU == 3) {
            super.vQ("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.vQ("4");
        } else {
            super.vQ("0");
        }
    }

    public void setThreadData(bu buVar) {
        this.aiq = buVar;
    }

    public void setTid(String str) {
        this.ajO = str;
    }

    public void BA(int i) {
        this.klV = i;
    }

    private int cLE() {
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
            String userId = this.ehD != null ? this.ehD.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12408").ag("obj_source", cLE()).dk("obj_id", userId).dk("tid", this.ajO));
            if (this.klU != 1) {
                if (this.klU == 3) {
                    i = 2;
                } else if (this.klU == 5) {
                    i = 5;
                } else if (this.klU == 7) {
                    i = 7;
                } else if (this.klU == 6) {
                    i = 6;
                } else {
                    i = this.klU == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c12507");
            aoVar.ag("obj_locate", i);
            aoVar.dk("obj_id", userId);
            aoVar.dk("tid", this.ajO);
            aoVar.ag("obj_param1", this.klV);
            if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aoVar);
            com.baidu.tbadk.core.util.ao aoVar2 = new com.baidu.tbadk.core.util.ao("c13570");
            aoVar2.dk("obj_id", userId);
            aoVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
            aoVar2.dk("tid", this.ajO);
            if (this.aiq != null) {
                aoVar2.dk("nid", this.aiq.getNid());
                if (this.aiq.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.ar.isEmpty(this.aiq.getBaijiahaoData().oriUgcVid)) {
                    aoVar2.dk("obj_param6", this.aiq.getBaijiahaoData().oriUgcVid);
                }
                aoVar2.dk(IntentConfig.RECOM_SOURCE, this.aiq.mRecomSource);
                aoVar2.dk("ab_tag", this.aiq.mRecomAbTag);
                aoVar2.dk("weight", this.aiq.mRecomWeight);
                aoVar2.dk("extra", this.aiq.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aoVar2);
            }
            TiebaStatic.log(aoVar2);
            super.onClick(view);
            if (this.klT && this.ehD != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11924").dk("obj_id", this.ehD.getUserId()));
            }
            if (this.isBigV && this.ehD != null) {
                if (this.klU == 1) {
                    i2 = 1;
                } else if (this.klU != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12150").ag("obj_locate", i2).dk("obj_id", this.ehD.getUserId()));
            }
        }
    }
}
