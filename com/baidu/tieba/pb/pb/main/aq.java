package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class aq extends com.baidu.tbadk.core.view.userLike.c {
    private String bBb;
    public boolean fQs;
    private int fQt;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public aq(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fQs = false;
        this.isBigV = false;
        this.fQt = 0;
        this.fQt = i;
        this.mPageContext = tbPageContext;
        if (this.fQt == 1) {
            super.setFromType("4");
        } else if (this.fQt == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cK(String str) {
        this.bBb = str;
    }

    private int bdd() {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdd()).aa("obj_id", this.bdH != null ? this.bdH.getUserId() : "").aa("tid", this.bBb));
        if (this.fQt == 1) {
            i = 3;
        } else {
            i = this.fQt == 3 ? 2 : 0;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12507").s("obj_locate", i));
        super.onClick(view);
        if (this.fQs && this.bdH != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").aa("obj_id", this.bdH.getUserId()));
        }
        if (this.isBigV && this.bdH != null) {
            if (this.fQt == 1) {
                i2 = 1;
            } else if (this.fQt != 2) {
                i2 = 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").s("obj_locate", i2).aa("obj_id", this.bdH.getUserId()));
        }
    }
}
