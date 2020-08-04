package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes16.dex */
public class ax extends com.baidu.tbadk.core.view.userLike.c {
    private bv aii;
    private String ajJ;
    public boolean isBigV;
    public boolean kuS;
    private int kuT;
    private int kuU;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.kuS = false;
        this.isBigV = false;
        this.kuT = 0;
        this.kuT = i;
        this.mPageContext = tbPageContext;
        if (this.kuT == 1) {
            super.wX("4");
        } else if (this.kuT == 3) {
            super.wX("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.wX("4");
        } else {
            super.wX("0");
        }
    }

    public void setThreadData(bv bvVar) {
        this.aii = bvVar;
    }

    public void setTid(String str) {
        this.ajJ = str;
    }

    public void BZ(int i) {
        this.kuU = i;
    }

    private int cPq() {
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
            String userId = this.enO != null ? this.enO.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12408").ah("obj_source", cPq()).dn("obj_id", userId).dn("tid", this.ajJ));
            if (this.kuT != 1) {
                if (this.kuT == 3) {
                    i = 2;
                } else if (this.kuT == 5) {
                    i = 5;
                } else if (this.kuT == 7) {
                    i = 7;
                } else if (this.kuT == 6) {
                    i = 6;
                } else {
                    i = this.kuT == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c12507");
            apVar.ah("obj_locate", i);
            apVar.dn("obj_id", userId);
            apVar.dn("tid", this.ajJ);
            apVar.ah("obj_param1", this.kuU);
            if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(apVar);
            com.baidu.tbadk.core.util.ap apVar2 = new com.baidu.tbadk.core.util.ap("c13570");
            apVar2.dn("obj_id", userId);
            apVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
            apVar2.dn("tid", this.ajJ);
            if (this.aii != null) {
                apVar2.dn("nid", this.aii.getNid());
                if (this.aii.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.as.isEmpty(this.aii.getBaijiahaoData().oriUgcVid)) {
                    apVar2.dn("obj_param6", this.aii.getBaijiahaoData().oriUgcVid);
                }
                apVar2.dn(IntentConfig.RECOM_SOURCE, this.aii.mRecomSource);
                apVar2.dn("ab_tag", this.aii.mRecomAbTag);
                apVar2.dn("weight", this.aii.mRecomWeight);
                apVar2.dn("extra", this.aii.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), apVar2);
            }
            TiebaStatic.log(apVar2);
            super.onClick(view);
            if (this.kuS && this.enO != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11924").dn("obj_id", this.enO.getUserId()));
            }
            if (this.isBigV && this.enO != null) {
                if (this.kuT == 1) {
                    i2 = 1;
                } else if (this.kuT != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12150").ah("obj_locate", i2).dn("obj_id", this.enO.getUserId()));
            }
        }
    }
}
