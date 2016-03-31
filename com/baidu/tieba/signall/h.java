package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String efX = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ab QV = null;

    public String ny(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.QV = new com.baidu.tbadk.core.util.ab(efX);
        this.QV.p("user_id", str2);
        this.QV.p("forum_ids", str);
        this.QV.vU().wO().adb = true;
        this.QV.vU().wO().mIsNeedTbs = true;
        return this.QV.vw();
    }

    public void cancel() {
        if (this.QV != null) {
            this.QV.gX();
        }
    }

    public boolean qC() {
        if (this.QV != null) {
            return this.QV.vU().wP().qC();
        }
        return false;
    }

    public String qD() {
        if (this.QV != null) {
            return this.QV.getErrorString();
        }
        return null;
    }
}
