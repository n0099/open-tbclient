package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class ar extends com.baidu.tbadk.core.view.userLike.c {
    private String aWq;
    private int fEA;
    private int fEB;
    public boolean fEz;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ar(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fEz = false;
        this.isBigV = false;
        this.fEA = 0;
        this.fEA = i;
        this.mPageContext = tbPageContext;
        if (this.fEA == 1) {
            super.setFromType("4");
        } else if (this.fEA == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void dh(String str) {
        this.aWq = str;
    }

    public void qM(int i) {
        this.fEB = i;
    }

    private int bdB() {
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
            String userId = this.azy != null ? this.azy.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdB()).af(VideoPlayActivityConfig.OBJ_ID, userId).af("tid", this.aWq));
            if (this.fEA != 1) {
                i = this.fEA == 3 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12507").r("obj_locate", i).af(VideoPlayActivityConfig.OBJ_ID, userId).af("tid", this.aWq).r("obj_param1", this.fEB));
            super.onClick(view);
            if (this.fEz && this.azy != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").af(VideoPlayActivityConfig.OBJ_ID, this.azy.getUserId()));
            }
            if (this.isBigV && this.azy != null) {
                if (this.fEA == 1) {
                    i2 = 1;
                } else if (this.fEA != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").r("obj_locate", i2).af(VideoPlayActivityConfig.OBJ_ID, this.azy.getUserId()));
            }
        }
    }
}
