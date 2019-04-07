package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    private String ctw;
    public boolean hvp;
    private int hvq;
    private int hvr;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.hvp = false;
        this.isBigV = false;
        this.hvq = 0;
        this.hvq = i;
        this.mPageContext = tbPageContext;
        if (this.hvq == 1) {
            super.setFromType("4");
        } else if (this.hvq == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.ctw = str;
    }

    public void wt(int i) {
        this.hvr = i;
    }

    private int bMf() {
        String fromPageKey = UtilHelper.getFromPageKey(this.mPageContext);
        if (fromPageKey == null) {
            return 3;
        }
        if (fromPageKey.equals("a038")) {
            return 1;
        }
        if (fromPageKey.equals("a002")) {
            return 2;
        }
        if (fromPageKey.equals("a006")) {
            return 3;
        }
        if (fromPageKey.equals("a011")) {
            return 4;
        }
        if (fromPageKey.equals("a033")) {
            return 5;
        }
        if (fromPageKey.equals("a010")) {
            return 6;
        }
        return 7;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 3;
        int i2 = 2;
        if (view != null && view.getAlpha() >= 0.4d) {
            String userId = this.bUA != null ? this.bUA.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bMf()).bJ(VideoPlayActivityConfig.OBJ_ID, userId).bJ("tid", this.ctw));
            if (this.hvq != 1) {
                i = this.hvq == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.T("obj_locate", i);
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.bJ("tid", this.ctw);
            amVar.T("obj_param1", this.hvr);
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.hvp && this.bUA != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").bJ(VideoPlayActivityConfig.OBJ_ID, this.bUA.getUserId()));
            }
            if (this.isBigV && this.bUA != null) {
                if (this.hvq == 1) {
                    i2 = 1;
                } else if (this.hvq != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").T("obj_locate", i2).bJ(VideoPlayActivityConfig.OBJ_ID, this.bUA.getUserId()));
            }
        }
    }
}
