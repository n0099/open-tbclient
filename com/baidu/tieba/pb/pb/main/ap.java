package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class ap extends com.baidu.tbadk.core.view.userLike.c {
    private String bCV;
    public boolean fTJ;
    private int fTK;
    private int fTL;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ap(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fTJ = false;
        this.isBigV = false;
        this.fTK = 0;
        this.fTK = i;
        this.mPageContext = tbPageContext;
        if (this.fTK == 1) {
            super.setFromType("4");
        } else if (this.fTK == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cV(String str) {
        this.bCV = str;
    }

    public void tb(int i) {
        this.fTL = i;
    }

    private int beF() {
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
        String userId = this.bfr != null ? this.bfr.getUserId() : "";
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, beF()).ab("obj_id", userId).ab("tid", this.bCV));
        if (this.fTK != 1) {
            i = this.fTK == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").s("obj_locate", i).ab("obj_id", userId).ab("tid", this.bCV).s("obj_param1", this.fTL));
        super.onClick(view);
        if (this.fTJ && this.bfr != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ab("obj_id", this.bfr.getUserId()));
        }
        if (this.isBigV && this.bfr != null) {
            if (this.fTK == 1) {
                i2 = 1;
            } else if (this.fTK != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").s("obj_locate", i2).ab("obj_id", this.bfr.getUserId()));
        }
    }
}
