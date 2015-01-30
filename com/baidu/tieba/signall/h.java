package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String bQU = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ad AR = null;

    public String hV(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.AR = new com.baidu.tbadk.core.util.ad(bQU);
        this.AR.o("user_id", str2);
        this.AR.o("forum_ids", str);
        this.AR.oZ().qg().Kx = true;
        this.AR.oZ().qg().mIsNeedTbs = true;
        return this.AR.oy();
    }

    public void cancel() {
        if (this.AR != null) {
            this.AR.dJ();
        }
    }

    public boolean ma() {
        if (this.AR != null) {
            return this.AR.oZ().qh().ma();
        }
        return false;
    }

    public String mb() {
        if (this.AR != null) {
            return this.AR.getErrorString();
        }
        return null;
    }
}
