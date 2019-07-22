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
    private String bWO;
    public boolean hTj;
    private int hTk;
    private int hTl;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.hTj = false;
        this.isBigV = false;
        this.hTk = 0;
        this.hTk = i;
        this.mPageContext = tbPageContext;
        if (this.hTk == 1) {
            super.setFromType("4");
        } else if (this.hTk == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.bWO = str;
    }

    public void yd(int i) {
        this.hTl = i;
    }

    private int bWN() {
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
            String userId = this.cdz != null ? this.cdz.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bWN()).bT(VideoPlayActivityConfig.OBJ_ID, userId).bT("tid", this.bWO));
            if (this.hTk != 1) {
                i = this.hTk == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.P("obj_locate", i);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, userId);
            anVar.bT("tid", this.bWO);
            anVar.P("obj_param1", this.hTl);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.hTj && this.cdz != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").bT(VideoPlayActivityConfig.OBJ_ID, this.cdz.getUserId()));
            }
            if (this.isBigV && this.cdz != null) {
                if (this.hTk == 1) {
                    i2 = 1;
                } else if (this.hTk != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").P("obj_locate", i2).bT(VideoPlayActivityConfig.OBJ_ID, this.cdz.getUserId()));
            }
        }
    }
}
