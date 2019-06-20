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
    private String bVM;
    public boolean hMW;
    private int hMX;
    private int hMY;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.hMW = false;
        this.isBigV = false;
        this.hMX = 0;
        this.hMX = i;
        this.mPageContext = tbPageContext;
        if (this.hMX == 1) {
            super.setFromType("4");
        } else if (this.hMX == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.bVM = str;
    }

    public void xz(int i) {
        this.hMY = i;
    }

    private int bUa() {
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
            String userId = this.ccx != null ? this.ccx.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bUa()).bT(VideoPlayActivityConfig.OBJ_ID, userId).bT("tid", this.bVM));
            if (this.hMX != 1) {
                i = this.hMX == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.P("obj_locate", i);
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.bT("tid", this.bVM);
            amVar.P("obj_param1", this.hMY);
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.hMW && this.ccx != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").bT(VideoPlayActivityConfig.OBJ_ID, this.ccx.getUserId()));
            }
            if (this.isBigV && this.ccx != null) {
                if (this.hMX == 1) {
                    i2 = 1;
                } else if (this.hMX != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").P("obj_locate", i2).bT(VideoPlayActivityConfig.OBJ_ID, this.ccx.getUserId()));
            }
        }
    }
}
