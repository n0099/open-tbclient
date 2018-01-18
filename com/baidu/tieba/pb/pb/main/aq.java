package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class aq extends com.baidu.tbadk.core.view.userLike.c {
    private String bAT;
    public boolean fPX;
    private int fPY;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public aq(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fPX = false;
        this.isBigV = false;
        this.fPY = 0;
        this.fPY = i;
        this.mPageContext = tbPageContext;
        if (this.fPY == 1) {
            super.setFromType("4");
        } else if (this.fPY == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cK(String str) {
        this.bAT = str;
    }

    private int bcY() {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bcY()).ab("obj_id", this.bdz != null ? this.bdz.getUserId() : "").ab("tid", this.bAT));
        if (this.fPY == 1) {
            i = 3;
        } else {
            i = this.fPY == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").s("obj_locate", i));
        super.onClick(view);
        if (this.fPX && this.bdz != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ab("obj_id", this.bdz.getUserId()));
        }
        if (this.isBigV && this.bdz != null) {
            if (this.fPY == 1) {
                i2 = 1;
            } else if (this.fPY != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").s("obj_locate", i2).ab("obj_id", this.bdz.getUserId()));
        }
    }
}
