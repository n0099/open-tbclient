package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class ar extends com.baidu.tbadk.core.view.userLike.c {
    private String aWo;
    public boolean fEm;
    private int fEn;
    private int fEo;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ar(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fEm = false;
        this.isBigV = false;
        this.fEn = 0;
        this.fEn = i;
        this.mPageContext = tbPageContext;
        if (this.fEn == 1) {
            super.setFromType("4");
        } else if (this.fEn == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void dk(String str) {
        this.aWo = str;
    }

    public void qP(int i) {
        this.fEo = i;
    }

    private int bfi() {
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
            String userId = this.azF != null ? this.azF.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bfi()).ah(VideoPlayActivityConfig.OBJ_ID, userId).ah("tid", this.aWo));
            if (this.fEn != 1) {
                i = this.fEn == 3 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12507").r("obj_locate", i).ah(VideoPlayActivityConfig.OBJ_ID, userId).ah("tid", this.aWo).r("obj_param1", this.fEo));
            super.onClick(view);
            if (this.fEm && this.azF != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").ah(VideoPlayActivityConfig.OBJ_ID, this.azF.getUserId()));
            }
            if (this.isBigV && this.azF != null) {
                if (this.fEn == 1) {
                    i2 = 1;
                } else if (this.fEn != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").r("obj_locate", i2).ah(VideoPlayActivityConfig.OBJ_ID, this.azF.getUserId()));
            }
        }
    }
}
