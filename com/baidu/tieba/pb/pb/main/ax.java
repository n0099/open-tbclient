package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes21.dex */
public class ax extends com.baidu.tbadk.core.view.userLike.c {
    private bx akt;
    private String alZ;
    public boolean isBigV;
    public boolean lBj;
    private int lBk;
    private int lBl;
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.lBj = false;
        this.isBigV = false;
        this.lBk = 0;
        this.lBk = i;
        this.mPageContext = tbPageContext;
        if (this.lBk == 1) {
            super.Av("4");
        } else if (this.lBk == 3) {
            super.Av("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.Av("4");
        } else {
            super.Av("0");
        }
    }

    public void setThreadData(bx bxVar) {
        this.akt = bxVar;
    }

    public void setTid(String str) {
        this.alZ = str;
    }

    public void GE(int i) {
        this.lBl = i;
    }

    private int dmB() {
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
            String userId = this.eZI != null ? this.eZI.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12408").ak("obj_source", dmB()).dR("obj_id", userId).dR("tid", this.alZ));
            if (this.lBk != 1) {
                if (this.lBk == 3) {
                    i = 2;
                } else if (this.lBk == 5) {
                    i = 5;
                } else if (this.lBk == 7) {
                    i = 7;
                } else if (this.lBk == 6) {
                    i = 6;
                } else {
                    i = this.lBk == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12507");
            arVar.ak("obj_locate", i);
            arVar.dR("obj_id", userId);
            arVar.dR("tid", this.alZ);
            arVar.ak("obj_param1", this.lBl);
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(arVar);
            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13570");
            arVar2.dR("obj_id", userId);
            arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar2.dR("tid", this.alZ);
            if (this.akt != null) {
                arVar2.dR("nid", this.akt.getNid());
                if (this.akt.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.akt.getBaijiahaoData().oriUgcVid)) {
                    arVar2.dR("obj_param6", this.akt.getBaijiahaoData().oriUgcVid);
                }
                arVar2.dR(IntentConfig.RECOM_SOURCE, this.akt.mRecomSource);
                arVar2.dR("ab_tag", this.akt.mRecomAbTag);
                arVar2.dR("weight", this.akt.mRecomWeight);
                arVar2.dR("extra", this.akt.mRecomExtra);
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar2);
            }
            TiebaStatic.log(arVar2);
            super.onClick(view);
            if (this.lBj && this.eZI != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11924").dR("obj_id", this.eZI.getUserId()));
            }
            if (this.isBigV && this.eZI != null) {
                if (this.lBk == 1) {
                    i2 = 1;
                } else if (this.lBk != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12150").ak("obj_locate", i2).dR("obj_id", this.eZI.getUserId()));
            }
        }
    }
}
