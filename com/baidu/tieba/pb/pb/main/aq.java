package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class aq extends com.baidu.tbadk.core.view.userLike.c {
    private String aVt;
    public boolean fAl;
    private int fAm;
    private int fAn;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public aq(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fAl = false;
        this.isBigV = false;
        this.fAm = 0;
        this.fAm = i;
        this.mPageContext = tbPageContext;
        if (this.fAm == 1) {
            super.setFromType("4");
        } else if (this.fAm == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void dh(String str) {
        this.aVt = str;
    }

    public void qH(int i) {
        this.fAn = i;
    }

    private int beA() {
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
            String userId = this.ayN != null ? this.ayN.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beA()).ah(VideoPlayActivityConfig.OBJ_ID, userId).ah("tid", this.aVt));
            if (this.fAm != 1) {
                i = this.fAm == 3 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12507").r("obj_locate", i).ah(VideoPlayActivityConfig.OBJ_ID, userId).ah("tid", this.aVt).r("obj_param1", this.fAn));
            super.onClick(view);
            if (this.fAl && this.ayN != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11924").ah(VideoPlayActivityConfig.OBJ_ID, this.ayN.getUserId()));
            }
            if (this.isBigV && this.ayN != null) {
                if (this.fAm == 1) {
                    i2 = 1;
                } else if (this.fAm != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12150").r("obj_locate", i2).ah(VideoPlayActivityConfig.OBJ_ID, this.ayN.getUserId()));
            }
        }
    }
}
