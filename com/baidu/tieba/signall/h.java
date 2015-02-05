package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String bQT = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ad AO = null;

    public String hT(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.AO = new com.baidu.tbadk.core.util.ad(bQT);
        this.AO.o("user_id", str2);
        this.AO.o("forum_ids", str);
        this.AO.oS().pZ().Ku = true;
        this.AO.oS().pZ().mIsNeedTbs = true;
        return this.AO.or();
    }

    public void cancel() {
        if (this.AO != null) {
            this.AO.dJ();
        }
    }

    public boolean lT() {
        if (this.AO != null) {
            return this.AO.oS().qa().lT();
        }
        return false;
    }

    public String lU() {
        if (this.AO != null) {
            return this.AO.getErrorString();
        }
        return null;
    }
}
