package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class ap extends com.baidu.tbadk.core.view.userLike.c {
    private String aMU;
    private int fbA;
    public boolean fbz;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fbz = false;
        this.isBigV = false;
        this.fbA = 0;
        this.fbA = i;
        this.mPageContext = tbPageContext;
        if (this.fbA == 1) {
            super.setFromType("4");
        } else if (this.fbA == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cD(String str) {
        this.aMU = str;
    }

    private int aVG() {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aVG()).ac("obj_id", this.aps != null ? this.aps.getUserId() : "").ac("tid", this.aMU));
        if (this.fbA == 1) {
            i = 3;
        } else {
            i = this.fbA == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").r("obj_locate", i));
        super.onClick(view);
        if (this.fbz && this.aps != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ac("obj_id", this.aps.getUserId()));
        }
        if (this.isBigV && this.aps != null) {
            if (this.fbA == 1) {
                i2 = 1;
            } else if (this.fbA != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").r("obj_locate", i2).ac("obj_id", this.aps.getUserId()));
        }
    }
}
