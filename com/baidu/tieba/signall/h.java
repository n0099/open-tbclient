package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String bPk = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ad AR = null;

    public String hO(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.AR = new com.baidu.tbadk.core.util.ad(bPk);
        this.AR.o("user_id", str2);
        this.AR.o("forum_ids", str);
        this.AR.oW().pV().Ke = true;
        this.AR.oW().pV().mIsNeedTbs = true;
        return this.AR.ov();
    }

    public void cancel() {
        if (this.AR != null) {
            this.AR.dL();
        }
    }

    public boolean ma() {
        if (this.AR != null) {
            return this.AR.oW().pW().ma();
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
