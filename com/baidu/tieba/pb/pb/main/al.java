package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes9.dex */
public class al extends com.baidu.tbadk.core.view.userLike.c {
    private String Pj;
    public boolean iNE;
    private int iNF;
    private int iNG;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public al(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.iNE = false;
        this.isBigV = false;
        this.iNF = 0;
        this.iNF = i;
        this.mPageContext = tbPageContext;
        if (this.iNF == 1) {
            super.sE("4");
        } else if (this.iNF == 3) {
            super.sE("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.sE("4");
        } else {
            super.sE("0");
        }
    }

    public void setTid(String str) {
        this.Pj = str;
    }

    public void zc(int i) {
        this.iNG = i;
    }

    private int cpa() {
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
            String userId = this.dke != null ? this.dke.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").X("obj_source", cpa()).cy("obj_id", userId).cy("tid", this.Pj));
            if (this.iNF != 1) {
                if (this.iNF == 3) {
                    i = 2;
                } else if (this.iNF == 5) {
                    i = 5;
                } else if (this.iNF == 7) {
                    i = 7;
                } else if (this.iNF == 6) {
                    i = 6;
                } else {
                    i = this.iNF == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.X("obj_locate", i);
            anVar.cy("obj_id", userId);
            anVar.cy("tid", this.Pj);
            anVar.X("obj_param1", this.iNG);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.iNE && this.dke != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").cy("obj_id", this.dke.getUserId()));
            }
            if (this.isBigV && this.dke != null) {
                if (this.iNF == 1) {
                    i2 = 1;
                } else if (this.iNF != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").X("obj_locate", i2).cy("obj_id", this.dke.getUserId()));
            }
        }
    }
}
