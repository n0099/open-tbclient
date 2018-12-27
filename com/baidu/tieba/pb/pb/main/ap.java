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
    private String biz;
    public boolean geB;
    private int geC;
    private int geD;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.geB = false;
        this.isBigV = false;
        this.geC = 0;
        this.geC = i;
        this.mPageContext = tbPageContext;
        if (this.geC == 1) {
            super.setFromType("4");
        } else if (this.geC == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.biz = str;
    }

    public void sK(int i) {
        this.geD = i;
    }

    private int blg() {
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
            String userId = this.aLv != null ? this.aLv.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, blg()).aA(VideoPlayActivityConfig.OBJ_ID, userId).aA("tid", this.biz));
            if (this.geC != 1) {
                i = this.geC == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.x("obj_locate", i);
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.aA("tid", this.biz);
            amVar.x("obj_param1", this.geD);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.geB && this.aLv != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").aA(VideoPlayActivityConfig.OBJ_ID, this.aLv.getUserId()));
            }
            if (this.isBigV && this.aLv != null) {
                if (this.geC == 1) {
                    i2 = 1;
                } else if (this.geC != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").x("obj_locate", i2).aA(VideoPlayActivityConfig.OBJ_ID, this.aLv.getUserId()));
            }
        }
    }
}
