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
    private String bjm;
    public boolean gfE;
    private int gfF;
    private int gfG;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.gfE = false;
        this.isBigV = false;
        this.gfF = 0;
        this.gfF = i;
        this.mPageContext = tbPageContext;
        if (this.gfF == 1) {
            super.setFromType("4");
        } else if (this.gfF == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.bjm = str;
    }

    public void sO(int i) {
        this.gfG = i;
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
            String userId = this.aLX != null ? this.aLX.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blO()).aB(VideoPlayActivityConfig.OBJ_ID, userId).aB("tid", this.bjm));
            if (this.gfF != 1) {
                i = this.gfF == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.y("obj_locate", i);
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.aB("tid", this.bjm);
            amVar.y("obj_param1", this.gfG);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.gfE && this.aLX != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").aB(VideoPlayActivityConfig.OBJ_ID, this.aLX.getUserId()));
            }
            if (this.isBigV && this.aLX != null) {
                if (this.gfF == 1) {
                    i2 = 1;
                } else if (this.gfF != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").y("obj_locate", i2).aB(VideoPlayActivityConfig.OBJ_ID, this.aLX.getUserId()));
            }
        }
    }
}
