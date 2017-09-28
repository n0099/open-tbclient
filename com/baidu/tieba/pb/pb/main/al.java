package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.core.view.userLike.c {
    private String cyX;
    public boolean eIS;
    private int eIT;
    public boolean isBigV;
    private TbPageContext mG;

    public al(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eIS = false;
        this.isBigV = false;
        this.eIT = 0;
        this.eIT = i;
        this.mG = tbPageContext;
        if (this.eIT == 1) {
            super.setFromType("4");
        } else if (this.eIT == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cy(String str) {
        this.cyX = str;
    }

    private int aQN() {
        String fromPageKey = UtilHelper.getFromPageKey(this.mG);
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
        int i;
        int i2 = 2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aQN()).ad("obj_id", this.aoN != null ? this.aoN.getUserId() : "").ad("tid", this.cyX));
        if (this.eIT == 1) {
            i = 3;
        } else {
            i = this.eIT == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").r("obj_locate", i));
        super.onClick(view);
        if (this.eIS && this.aoN != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ad("obj_id", this.aoN.getUserId()));
        }
        if (this.isBigV && this.aoN != null) {
            if (this.eIT == 1) {
                i2 = 1;
            } else if (this.eIT != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").r("obj_locate", i2).ad("obj_id", this.aoN.getUserId()));
        }
    }
}
