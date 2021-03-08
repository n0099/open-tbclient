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
    private cb amn;
    private String anU;
    public boolean isBigV;
    private TbPageContext mPageContext;
    public boolean maV;
    private int maW;
    private int maX;

    public an(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.maV = false;
        this.isBigV = false;
        this.maW = 0;
        this.maW = i;
        this.mPageContext = tbPageContext;
        if (this.maW == 1) {
            super.An("4");
        } else if (this.maW == 3) {
            super.An("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.An("4");
        } else {
            super.An("0");
        }
    }

    public void setThreadData(cb cbVar) {
        this.amn = cbVar;
    }

    public void setTid(String str) {
        this.anU = str;
    }

    public void Gd(int i) {
        this.maX = i;
    }

    private int dqs() {
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
            String userId = this.fpY != null ? this.fpY.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12408").aq("obj_source", dqs()).dR("obj_id", userId).dR("tid", this.anU));
            if (this.maW != 1) {
                if (this.maW == 3) {
                    i = 2;
                } else if (this.maW == 5) {
                    i = 5;
                } else if (this.maW == 7) {
                    i = 7;
                } else if (this.maW == 6) {
                    i = 6;
                } else {
                    i = this.maW == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12507");
            arVar.aq("obj_locate", i);
            arVar.dR("obj_id", userId);
            arVar.dR("tid", this.anU);
            arVar.aq("obj_param1", this.maX);
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13570");
            arVar2.dR("obj_id", userId);
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar2.dR("tid", this.anU);
            if (this.amn != null) {
                arVar2.dR(IntentConfig.NID, this.amn.bmq());
                if (this.amn.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.amn.getBaijiahaoData().oriUgcVid)) {
                    arVar2.dR("obj_param6", this.amn.getBaijiahaoData().oriUgcVid);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, this.amn.mRecomSource);
                arVar2.dR("ab_tag", this.amn.mRecomAbTag);
                arVar2.dR("weight", this.amn.mRecomWeight);
                arVar2.dR("extra", this.amn.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar2);
            }
            TiebaStatic.log(arVar2);
            super.onClick(view);
            if (this.maV && this.fpY != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11924").dR("obj_id", this.fpY.getUserId()));
            }
            if (this.isBigV && this.fpY != null) {
                if (this.maW == 1) {
                    i2 = 1;
                } else if (this.maW != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12150").aq("obj_locate", i2).dR("obj_id", this.fpY.getUserId()));
            }
        }
    }
}
