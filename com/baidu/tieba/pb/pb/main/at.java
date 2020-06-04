package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes9.dex */
public class at extends com.baidu.tbadk.core.view.userLike.c {
    private bk ahg;
    private String ais;
    public boolean isBigV;
    public boolean jSd;
    private int jSe;
    private int jSf;
    private TbPageContext mPageContext;

    public at(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.jSd = false;
        this.isBigV = false;
        this.jSe = 0;
        this.jSe = i;
        this.mPageContext = tbPageContext;
        if (this.jSe == 1) {
            super.vA("4");
        } else if (this.jSe == 3) {
            super.vA("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.vA("4");
        } else {
            super.vA("0");
        }
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public void setTid(String str) {
        this.ais = str;
    }

    public void Ay(int i) {
        this.jSf = i;
    }

    private int cHm() {
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
            String userId = this.dYT != null ? this.dYT.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").ag("obj_source", cHm()).dh("obj_id", userId).dh("tid", this.ais));
            if (this.jSe != 1) {
                if (this.jSe == 3) {
                    i = 2;
                } else if (this.jSe == 5) {
                    i = 5;
                } else if (this.jSe == 7) {
                    i = 7;
                } else if (this.jSe == 6) {
                    i = 6;
                } else {
                    i = this.jSe == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.ag("obj_locate", i);
            anVar.dh("obj_id", userId);
            anVar.dh("tid", this.ais);
            anVar.ag("obj_param1", this.jSf);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13570");
            anVar2.dh("obj_id", userId);
            anVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar2.dh("tid", this.ais);
            if (this.ahg != null) {
                anVar2.dh("nid", this.ahg.getNid());
                if (this.ahg.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.ahg.getBaijiahaoData().oriUgcVid)) {
                    anVar2.dh("obj_param6", this.ahg.getBaijiahaoData().oriUgcVid);
                }
                anVar2.dh(IntentConfig.RECOM_SOURCE, this.ahg.mRecomSource);
                anVar2.dh("ab_tag", this.ahg.mRecomAbTag);
                anVar2.dh("weight", this.ahg.mRecomWeight);
                anVar2.dh("extra", this.ahg.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), anVar2);
            }
            TiebaStatic.log(anVar2);
            super.onClick(view);
            if (this.jSd && this.dYT != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").dh("obj_id", this.dYT.getUserId()));
            }
            if (this.isBigV && this.dYT != null) {
                if (this.jSe == 1) {
                    i2 = 1;
                } else if (this.jSe != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").ag("obj_locate", i2).dh("obj_id", this.dYT.getUserId()));
            }
        }
    }
}
