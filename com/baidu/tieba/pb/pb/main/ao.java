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
    private String bXN;
    public boolean hWc;
    private int hWd;
    private int hWe;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.hWc = false;
        this.isBigV = false;
        this.hWd = 0;
        this.hWd = i;
        this.mPageContext = tbPageContext;
        if (this.hWd == 1) {
            super.setFromType("4");
        } else if (this.hWd == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.bXN = str;
    }

    public void yi(int i) {
        this.hWe = i;
    }

    private int bXR() {
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
            String userId = this.cez != null ? this.cez.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bXR()).bT(VideoPlayActivityConfig.OBJ_ID, userId).bT("tid", this.bXN));
            if (this.hWd != 1) {
                i = this.hWd == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.P("obj_locate", i);
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, userId);
            anVar.bT("tid", this.bXN);
            anVar.P("obj_param1", this.hWe);
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.hWc && this.cez != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").bT(VideoPlayActivityConfig.OBJ_ID, this.cez.getUserId()));
            }
            if (this.isBigV && this.cez != null) {
                if (this.hWd == 1) {
                    i2 = 1;
                } else if (this.hWd != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").P("obj_locate", i2).bT(VideoPlayActivityConfig.OBJ_ID, this.cez.getUserId()));
            }
        }
    }
}
