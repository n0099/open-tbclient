package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    private String OG;
    public boolean iMi;
    private int iMj;
    private int iMk;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.iMi = false;
        this.isBigV = false;
        this.iMj = 0;
        this.iMj = i;
        this.mPageContext = tbPageContext;
        if (this.iMj == 1) {
            super.sn("4");
        } else if (this.iMj == 3) {
            super.sn("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.sn("4");
        } else {
            super.sn("0");
        }
    }

    public void setTid(String str) {
        this.OG = str;
    }

    public void yW(int i) {
        this.iMk = i;
    }

    private int cnH() {
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
            String userId = this.dfX != null ? this.dfX.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").Z("obj_source", cnH()).cp("obj_id", userId).cp("tid", this.OG));
            if (this.iMj != 1) {
                if (this.iMj == 3) {
                    i = 2;
                } else if (this.iMj == 5) {
                    i = 5;
                } else if (this.iMj == 7) {
                    i = 7;
                } else if (this.iMj == 6) {
                    i = 6;
                } else {
                    i = this.iMj == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.Z("obj_locate", i);
            anVar.cp("obj_id", userId);
            anVar.cp("tid", this.OG);
            anVar.Z("obj_param1", this.iMk);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.iMi && this.dfX != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").cp("obj_id", this.dfX.getUserId()));
            }
            if (this.isBigV && this.dfX != null) {
                if (this.iMj == 1) {
                    i2 = 1;
                } else if (this.iMj != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").Z("obj_locate", i2).cp("obj_id", this.dfX.getUserId()));
            }
        }
    }
}
