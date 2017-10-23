package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.core.view.userLike.c {
    private String cyL;
    public boolean eIE;
    private int eIF;
    public boolean isBigV;
    private TbPageContext mH;

    public al(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eIE = false;
        this.isBigV = false;
        this.eIF = 0;
        this.eIF = i;
        this.mH = tbPageContext;
        if (this.eIF == 1) {
            super.setFromType("4");
        } else if (this.eIF == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cx(String str) {
        this.cyL = str;
    }

    private int aQI() {
        String fromPageKey = UtilHelper.getFromPageKey(this.mH);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aQI()).ac("obj_id", this.aoB != null ? this.aoB.getUserId() : "").ac("tid", this.cyL));
        if (this.eIF == 1) {
            i = 3;
        } else {
            i = this.eIF == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").r("obj_locate", i));
        super.onClick(view);
        if (this.eIE && this.aoB != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ac("obj_id", this.aoB.getUserId()));
        }
        if (this.isBigV && this.aoB != null) {
            if (this.eIF == 1) {
                i2 = 1;
            } else if (this.eIF != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").r("obj_locate", i2).ac("obj_id", this.aoB.getUserId()));
        }
    }
}
