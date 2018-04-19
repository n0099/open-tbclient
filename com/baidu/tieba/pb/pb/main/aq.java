package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class aq extends com.baidu.tbadk.core.view.userLike.c {
    private String aNu;
    public boolean fnN;
    private int fnO;
    private int fnP;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public aq(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fnN = false;
        this.isBigV = false;
        this.fnO = 0;
        this.fnO = i;
        this.mPageContext = tbPageContext;
        if (this.fnO == 1) {
            super.setFromType("4");
        } else if (this.fnO == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void cJ(String str) {
        this.aNu = str;
    }

    public void qw(int i) {
        this.fnP = i;
    }

    private int aZC() {
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
    public void onClick(View view2) {
        int i = 3;
        int i2 = 2;
        if (view2 != null && view2.getAlpha() >= 0.4d) {
            String userId = this.aqG != null ? this.aqG.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aZC()).ac(VideoPlayActivityConfig.OBJ_ID, userId).ac("tid", this.aNu));
            if (this.fnO != 1) {
                i = this.fnO == 3 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12507").r("obj_locate", i).ac(VideoPlayActivityConfig.OBJ_ID, userId).ac("tid", this.aNu).r("obj_param1", this.fnP));
            super.onClick(view2);
            if (this.fnN && this.aqG != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11924").ac(VideoPlayActivityConfig.OBJ_ID, this.aqG.getUserId()));
            }
            if (this.isBigV && this.aqG != null) {
                if (this.fnO == 1) {
                    i2 = 1;
                } else if (this.fnO != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12150").r("obj_locate", i2).ac(VideoPlayActivityConfig.OBJ_ID, this.aqG.getUserId()));
            }
        }
    }
}
