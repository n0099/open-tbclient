package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String bKU = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ac mNetWork = null;

    public String hp(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new com.baidu.tbadk.core.util.ac(bKU);
        this.mNetWork.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, str2);
        this.mNetWork.k("forum_ids", str);
        this.mNetWork.mc().na().FU = true;
        this.mNetWork.mc().na().mIsNeedTbs = true;
        return this.mNetWork.lA();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
    }

    public boolean jq() {
        if (this.mNetWork != null) {
            return this.mNetWork.mc().nb().jq();
        }
        return false;
    }

    public String jr() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
