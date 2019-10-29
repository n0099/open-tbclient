package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    private String cmS;
    public boolean hUK;
    private int hUL;
    private int hUM;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.hUK = false;
        this.isBigV = false;
        this.hUL = 0;
        this.hUL = i;
        this.mPageContext = tbPageContext;
        if (this.hUL == 1) {
            super.mX("4");
        } else if (this.hUL == 3) {
            super.mX("5");
        } else {
            super.mX("0");
        }
    }

    public void setTid(String str) {
        this.cmS = str;
    }

    public void wO(int i) {
        this.hUM = i;
    }

    private int bUT() {
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
            String userId = this.csN != null ? this.csN.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").O("obj_source", bUT()).bS("obj_id", userId).bS("tid", this.cmS));
            if (this.hUL != 1) {
                i = this.hUL == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.O("obj_locate", i);
            anVar.bS("obj_id", userId);
            anVar.bS("tid", this.cmS);
            anVar.O("obj_param1", this.hUM);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.hUK && this.csN != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").bS("obj_id", this.csN.getUserId()));
            }
            if (this.isBigV && this.csN != null) {
                if (this.hUL == 1) {
                    i2 = 1;
                } else if (this.hUL != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").O("obj_locate", i2).bS("obj_id", this.csN.getUserId()));
            }
        }
    }
}
