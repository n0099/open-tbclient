package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class i {
    private static final String ced = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.aa Ok = null;

    public String im(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Ok = new com.baidu.tbadk.core.util.aa(ced);
        this.Ok.o("user_id", str2);
        this.Ok.o("forum_ids", str);
        this.Ok.sp().tp().VW = true;
        this.Ok.sp().tp().mIsNeedTbs = true;
        return this.Ok.rO();
    }

    public void cancel() {
        if (this.Ok != null) {
            this.Ok.hh();
        }
    }

    public boolean pv() {
        if (this.Ok != null) {
            return this.Ok.sp().tq().pv();
        }
        return false;
    }

    public String pw() {
        if (this.Ok != null) {
            return this.Ok.getErrorString();
        }
        return null;
    }
}
