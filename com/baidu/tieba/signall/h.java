package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String cPP = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.w Th = null;

    public String le(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Th = new com.baidu.tbadk.core.util.w(cPP);
        this.Th.o("user_id", str2);
        this.Th.o("forum_ids", str);
        this.Th.uh().uX().abL = true;
        this.Th.uh().uX().mIsNeedTbs = true;
        return this.Th.tG();
    }

    public void cancel() {
        if (this.Th != null) {
            this.Th.gJ();
        }
    }

    public boolean qV() {
        if (this.Th != null) {
            return this.Th.uh().uY().qV();
        }
        return false;
    }

    public String qW() {
        if (this.Th != null) {
            return this.Th.getErrorString();
        }
        return null;
    }
}
