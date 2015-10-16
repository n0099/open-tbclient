package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String cQo = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.w Ti = null;

    public String lh(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Ti = new com.baidu.tbadk.core.util.w(cQo);
        this.Ti.o("user_id", str2);
        this.Ti.o("forum_ids", str);
        this.Ti.uh().uY().abO = true;
        this.Ti.uh().uY().mIsNeedTbs = true;
        return this.Ti.tG();
    }

    public void cancel() {
        if (this.Ti != null) {
            this.Ti.gJ();
        }
    }

    public boolean qV() {
        if (this.Ti != null) {
            return this.Ti.uh().uZ().qV();
        }
        return false;
    }

    public String qW() {
        if (this.Ti != null) {
            return this.Ti.getErrorString();
        }
        return null;
    }
}
