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
    private bz alW;
    private String anD;
    public boolean isBigV;
    public boolean lUj;
    private int lUk;
    private int lUl;
    private TbPageContext mPageContext;

    public an(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.lUj = false;
        this.isBigV = false;
        this.lUk = 0;
        this.lUk = i;
        this.mPageContext = tbPageContext;
        if (this.lUk == 1) {
            super.Ba("4");
        } else if (this.lUk == 3) {
            super.Ba("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.Ba("4");
        } else {
            super.Ba("0");
        }
    }

    public void setThreadData(bz bzVar) {
        this.alW = bzVar;
    }

    public void setTid(String str) {
        this.anD = str;
    }

    public void Hn(int i) {
        this.lUl = i;
    }

    private int drG() {
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
            String userId = this.fqP != null ? this.fqP.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12408").an("obj_source", drG()).dX("obj_id", userId).dX("tid", this.anD));
            if (this.lUk != 1) {
                if (this.lUk == 3) {
                    i = 2;
                } else if (this.lUk == 5) {
                    i = 5;
                } else if (this.lUk == 7) {
                    i = 7;
                } else if (this.lUk == 6) {
                    i = 6;
                } else {
                    i = this.lUk == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12507");
            aqVar.an("obj_locate", i);
            aqVar.dX("obj_id", userId);
            aqVar.dX("tid", this.anD);
            aqVar.an("obj_param1", this.lUl);
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aqVar);
            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13570");
            aqVar2.dX("obj_id", userId);
            aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar2.dX("tid", this.anD);
            if (this.alW != null) {
                aqVar2.dX(IntentConfig.NID, this.alW.bpP());
                if (this.alW.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.alW.getBaijiahaoData().oriUgcVid)) {
                    aqVar2.dX("obj_param6", this.alW.getBaijiahaoData().oriUgcVid);
                }
                aqVar2.dX(IntentConfig.RECOM_SOURCE, this.alW.mRecomSource);
                aqVar2.dX("ab_tag", this.alW.mRecomAbTag);
                aqVar2.dX("weight", this.alW.mRecomWeight);
                aqVar2.dX("extra", this.alW.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar2);
            }
            TiebaStatic.log(aqVar2);
            super.onClick(view);
            if (this.lUj && this.fqP != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11924").dX("obj_id", this.fqP.getUserId()));
            }
            if (this.isBigV && this.fqP != null) {
                if (this.lUk == 1) {
                    i2 = 1;
                } else if (this.lUk != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12150").an("obj_locate", i2).dX("obj_id", this.fqP.getUserId()));
            }
        }
    }
}
