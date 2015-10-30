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
        this.Ti.ue().uV().abO = true;
        this.Ti.ue().uV().mIsNeedTbs = true;
        return this.Ti.tD();
    }

    public void cancel() {
        if (this.Ti != null) {
            this.Ti.gJ();
        }
    }

    public boolean qS() {
        if (this.Ti != null) {
            return this.Ti.ue().uW().qS();
        }
        return false;
    }

    public String qT() {
        if (this.Ti != null) {
            return this.Ti.getErrorString();
        }
        return null;
    }
}
