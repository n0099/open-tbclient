package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.core.view.userLike.c {
    public boolean ePa;
    private int ePb;
    public boolean isBigV;
    private TbPageContext mF;

    public al(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.ePa = false;
        this.isBigV = false;
        this.ePb = 0;
        this.ePb = i;
        this.mF = tbPageContext;
    }

    private int aSJ() {
        String fromPageKey = UtilHelper.getFromPageKey(this.mF);
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
        int i = 1;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aSJ()));
        super.onClick(view);
        if (this.ePa && this.apD != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ad("obj_id", this.apD.getUserId()));
        }
        if (this.isBigV && this.apD != null) {
            if (this.ePb != 1) {
                i = this.ePb == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").r("obj_locate", i).ad("obj_id", this.apD.getUserId()));
        }
    }
}
