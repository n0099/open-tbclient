package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String dxu = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ab Ua = null;

    public String lX(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Ua = new com.baidu.tbadk.core.util.ab(dxu);
        this.Ua.o("user_id", str2);
        this.Ua.o("forum_ids", str);
        this.Ua.uw().vp().adq = true;
        this.Ua.uw().vp().mIsNeedTbs = true;
        return this.Ua.tV();
    }

    public void cancel() {
        if (this.Ua != null) {
            this.Ua.gL();
        }
    }

    public boolean qO() {
        if (this.Ua != null) {
            return this.Ua.uw().vq().qO();
        }
        return false;
    }

    public String qP() {
        if (this.Ua != null) {
            return this.Ua.getErrorString();
        }
        return null;
    }
}
