package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String cRK = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.w Tj = null;

    public String ll(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Tj = new com.baidu.tbadk.core.util.w(cRK);
        this.Tj.o("user_id", str2);
        this.Tj.o("forum_ids", str);
        this.Tj.uh().uZ().abT = true;
        this.Tj.uh().uZ().mIsNeedTbs = true;
        return this.Tj.tG();
    }

    public void cancel() {
        if (this.Tj != null) {
            this.Tj.gJ();
        }
    }

    public boolean qT() {
        if (this.Tj != null) {
            return this.Tj.uh().va().qT();
        }
        return false;
    }

    public String qU() {
        if (this.Tj != null) {
            return this.Tj.getErrorString();
        }
        return null;
    }
}
