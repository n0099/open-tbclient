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
    private String beV;
    public boolean fUS;
    private int fUT;
    private int fUU;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fUS = false;
        this.isBigV = false;
        this.fUT = 0;
        this.fUT = i;
        this.mPageContext = tbPageContext;
        if (this.fUT == 1) {
            super.setFromType("4");
        } else if (this.fUT == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.beV = str;
    }

    public void sd(int i) {
        this.fUU = i;
    }

    private int biD() {
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
            String userId = this.aHT != null ? this.aHT.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, biD()).ax(VideoPlayActivityConfig.OBJ_ID, userId).ax("tid", this.beV));
            if (this.fUT != 1) {
                i = this.fUT == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12507");
            amVar.x("obj_locate", i);
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, userId);
            amVar.ax("tid", this.beV);
            amVar.x("obj_param1", this.fUU);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
            super.onClick(view);
            if (this.fUS && this.aHT != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").ax(VideoPlayActivityConfig.OBJ_ID, this.aHT.getUserId()));
            }
            if (this.isBigV && this.aHT != null) {
                if (this.fUT == 1) {
                    i2 = 1;
                } else if (this.fUT != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").x("obj_locate", i2).ax(VideoPlayActivityConfig.OBJ_ID, this.aHT.getUserId()));
            }
        }
    }
}
