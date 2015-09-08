package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String cIU = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.v Tv = null;

    public String kG(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Tv = new com.baidu.tbadk.core.util.v(cIU);
        this.Tv.o("user_id", str2);
        this.Tv.o("forum_ids", str);
        this.Tv.uj().uZ().abM = true;
        this.Tv.uj().uZ().mIsNeedTbs = true;
        return this.Tv.tI();
    }

    public void cancel() {
        if (this.Tv != null) {
            this.Tv.gJ();
        }
    }

    public boolean qZ() {
        if (this.Tv != null) {
            return this.Tv.uj().va().qZ();
        }
        return false;
    }

    public String ra() {
        if (this.Tv != null) {
            return this.Tv.getErrorString();
        }
        return null;
    }
}
