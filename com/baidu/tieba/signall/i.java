package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class i {
    private static final String cdO = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.aa Oi = null;

    public String ij(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Oi = new com.baidu.tbadk.core.util.aa(cdO);
        this.Oi.o("user_id", str2);
        this.Oi.o("forum_ids", str);
        this.Oi.sp().tp().VU = true;
        this.Oi.sp().tp().mIsNeedTbs = true;
        return this.Oi.rO();
    }

    public void cancel() {
        if (this.Oi != null) {
            this.Oi.hh();
        }
    }

    public boolean pv() {
        if (this.Oi != null) {
            return this.Oi.sp().tq().pv();
        }
        return false;
    }

    public String pw() {
        if (this.Oi != null) {
            return this.Oi.getErrorString();
        }
        return null;
    }
}
