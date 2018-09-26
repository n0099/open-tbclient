package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class ap extends com.baidu.tbadk.core.view.userLike.c {
    private String aZG;
    public boolean fLR;
    private int fLS;
    private int fLT;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fLR = false;
        this.isBigV = false;
        this.fLS = 0;
        this.fLS = i;
        this.mPageContext = tbPageContext;
        if (this.fLS == 1) {
            super.setFromType("4");
        } else if (this.fLS == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.aZG = str;
    }

    public void rn(int i) {
        this.fLT = i;
    }

    private int bfU() {
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
            String userId = this.aCx != null ? this.aCx.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bfU()).al(VideoPlayActivityConfig.OBJ_ID, userId).al("tid", this.aZG));
            if (this.fLS != 1) {
                i = this.fLS == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.w("obj_locate", i);
            amVar.al(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.al("tid", this.aZG);
            amVar.w("obj_param1", this.fLT);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.fLR && this.aCx != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").al(VideoPlayActivityConfig.OBJ_ID, this.aCx.getUserId()));
            }
            if (this.isBigV && this.aCx != null) {
                if (this.fLS == 1) {
                    i2 = 1;
                } else if (this.fLS != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").w("obj_locate", i2).al(VideoPlayActivityConfig.OBJ_ID, this.aCx.getUserId()));
            }
        }
    }
}
