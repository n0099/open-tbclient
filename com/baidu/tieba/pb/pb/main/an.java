package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.core.view.userLike.c {
    private String aMq;
    public boolean eRL;
    private int eRM;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public an(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eRL = false;
        this.isBigV = false;
        this.eRM = 0;
        this.eRM = i;
        this.mPageContext = tbPageContext;
        if (this.eRM == 1) {
            super.setFromType("4");
        } else if (this.eRM == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cD(String str) {
        this.aMq = str;
    }

    private int aTX() {
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
        int i;
        int i2 = 2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aTX()).ac("obj_id", this.aoW != null ? this.aoW.getUserId() : "").ac("tid", this.aMq));
        if (this.eRM == 1) {
            i = 3;
        } else {
            i = this.eRM == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").r("obj_locate", i));
        super.onClick(view);
        if (this.eRL && this.aoW != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ac("obj_id", this.aoW.getUserId()));
        }
        if (this.isBigV && this.aoW != null) {
            if (this.eRM == 1) {
                i2 = 1;
            } else if (this.eRM != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").r("obj_locate", i2).ac("obj_id", this.aoW.getUserId()));
        }
    }
}
