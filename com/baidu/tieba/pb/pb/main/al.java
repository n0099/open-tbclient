package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.core.view.userLike.c {
    public boolean eOg;
    private int eOh;
    public boolean isBigV;
    private TbPageContext mF;

    public al(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eOg = false;
        this.isBigV = false;
        this.eOh = 0;
        this.eOh = i;
        this.mF = tbPageContext;
    }

    private int aSy() {
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aSy()));
        super.onClick(view);
        if (this.eOg && this.apF != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11924").ad("obj_id", this.apF.getUserId()));
        }
        if (this.isBigV && this.apF != null) {
            if (this.eOh != 1) {
                i = this.eOh == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12150").r("obj_locate", i).ad("obj_id", this.apF.getUserId()));
        }
    }
}
