package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    private String OC;
    public boolean iIE;
    private int iIF;
    private int iIG;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.iIE = false;
        this.isBigV = false;
        this.iIF = 0;
        this.iIF = i;
        this.mPageContext = tbPageContext;
        if (this.iIF == 1) {
            super.sk("4");
        } else if (this.iIF == 3) {
            super.sk("5");
        } else if (i == 4 || i == 5 || i == 6) {
            super.sk("4");
        } else {
            super.sk("0");
        }
    }

    public void setTid(String str) {
        this.OC = str;
    }

    public void yR(int i) {
        this.iIG = i;
    }

    private int cmA() {
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
            String userId = this.dfL != null ? this.dfL.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").Z("obj_source", cmA()).cp("obj_id", userId).cp("tid", this.OC));
            if (this.iIF != 1) {
                if (this.iIF == 3) {
                    i = 2;
                } else if (this.iIF == 5) {
                    i = 5;
                } else if (this.iIF == 7) {
                    i = 7;
                } else if (this.iIF == 6) {
                    i = 6;
                } else {
                    i = this.iIF == 4 ? 4 : 0;
                }
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.Z("obj_locate", i);
            anVar.cp("obj_id", userId);
            anVar.cp("tid", this.OC);
            anVar.Z("obj_param1", this.iIG);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.iIE && this.dfL != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").cp("obj_id", this.dfL.getUserId()));
            }
            if (this.isBigV && this.dfL != null) {
                if (this.iIF == 1) {
                    i2 = 1;
                } else if (this.iIF != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").Z("obj_locate", i2).cp("obj_id", this.dfL.getUserId()));
            }
        }
    }
}
