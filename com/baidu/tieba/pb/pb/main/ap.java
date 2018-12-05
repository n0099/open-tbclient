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
    private String biw;
    public boolean gbI;
    private int gbJ;
    private int gbK;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.gbI = false;
        this.isBigV = false;
        this.gbJ = 0;
        this.gbJ = i;
        this.mPageContext = tbPageContext;
        if (this.gbJ == 1) {
            super.setFromType("4");
        } else if (this.gbJ == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.biw = str;
    }

    public void sx(int i) {
        this.gbK = i;
    }

    private int bkv() {
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
            String userId = this.aLt != null ? this.aLt.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bkv()).aA(VideoPlayActivityConfig.OBJ_ID, userId).aA("tid", this.biw));
            if (this.gbJ != 1) {
                i = this.gbJ == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.x("obj_locate", i);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.aA("tid", this.biw);
            amVar.x("obj_param1", this.gbK);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.gbI && this.aLt != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").aA(VideoPlayActivityConfig.OBJ_ID, this.aLt.getUserId()));
            }
            if (this.isBigV && this.aLt != null) {
                if (this.gbJ == 1) {
                    i2 = 1;
                } else if (this.gbJ != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").x("obj_locate", i2).aA(VideoPlayActivityConfig.OBJ_ID, this.aLt.getUserId()));
            }
        }
    }
}
