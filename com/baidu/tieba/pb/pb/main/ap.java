package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class ap extends com.baidu.tbadk.core.view.userLike.c {
    private String bjn;
    public boolean gfF;
    private int gfG;
    private int gfH;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.gfF = false;
        this.isBigV = false;
        this.gfG = 0;
        this.gfG = i;
        this.mPageContext = tbPageContext;
        if (this.gfG == 1) {
            super.setFromType("4");
        } else if (this.gfG == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.bjn = str;
    }

    public void sO(int i) {
        this.gfH = i;
    }

    private int blO() {
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
            String userId = this.aLY != null ? this.aLY.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blO()).aB(VideoPlayActivityConfig.OBJ_ID, userId).aB("tid", this.bjn));
            if (this.gfG != 1) {
                i = this.gfG == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.y("obj_locate", i);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.aB("tid", this.bjn);
            amVar.y("obj_param1", this.gfH);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.gfF && this.aLY != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").aB(VideoPlayActivityConfig.OBJ_ID, this.aLY.getUserId()));
            }
            if (this.isBigV && this.aLY != null) {
                if (this.gfG == 1) {
                    i2 = 1;
                } else if (this.gfG != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").y("obj_locate", i2).aB(VideoPlayActivityConfig.OBJ_ID, this.aLY.getUserId()));
            }
        }
    }
}
