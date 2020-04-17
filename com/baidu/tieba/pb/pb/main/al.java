package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes9.dex */
public class al extends com.baidu.tbadk.core.view.userLike.c {
    private String ahL;
    public boolean isBigV;
    public boolean jzA;
    private int jzB;
    private int jzC;
    private TbPageContext mPageContext;

    public al(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.jzA = false;
        this.isBigV = false;
        this.jzB = 0;
        this.jzB = i;
        this.mPageContext = tbPageContext;
        if (this.jzB == 1) {
            super.tR("4");
        } else if (this.jzB == 3) {
            super.tR("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.tR("4");
        } else {
            super.tR("0");
        }
    }

    public void setTid(String str) {
        this.ahL = str;
    }

    public void zL(int i) {
        this.jzC = i;
    }

    private int cAc() {
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
            String userId = this.dKy != null ? this.dKy.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").af("obj_source", cAc()).cI("obj_id", userId).cI("tid", this.ahL));
            if (this.jzB != 1) {
                if (this.jzB == 3) {
                    i = 2;
                } else if (this.jzB == 5) {
                    i = 5;
                } else if (this.jzB == 7) {
                    i = 7;
                } else if (this.jzB == 6) {
                    i = 6;
                } else {
                    i = this.jzB == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.af("obj_locate", i);
            anVar.cI("obj_id", userId);
            anVar.cI("tid", this.ahL);
            anVar.af("obj_param1", this.jzC);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.jzA && this.dKy != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").cI("obj_id", this.dKy.getUserId()));
            }
            if (this.isBigV && this.dKy != null) {
                if (this.jzB == 1) {
                    i2 = 1;
                } else if (this.jzB != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").af("obj_locate", i2).cI("obj_id", this.dKy.getUserId()));
            }
        }
    }
}
