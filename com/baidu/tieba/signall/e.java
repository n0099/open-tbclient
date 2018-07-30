package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes3.dex */
public class e {
    private static final String gEH = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private y mNetWork = null;

    public String bsI() {
        this.mNetWork = new y(gEH);
        this.mNetWork.yO().zM().arR = true;
        this.mNetWork.yO().zM().mIsNeedTbs = true;
        return this.mNetWork.yq();
    }

    public String tp(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new y(gEH);
        this.mNetWork.o("user_id", str2);
        this.mNetWork.o("forum_ids", str);
        this.mNetWork.yO().zM().arR = true;
        this.mNetWork.yO().zM().mIsNeedTbs = true;
        return this.mNetWork.yq();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.hN();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.yO().zN().isRequestSuccess();
        }
        return false;
    }

    public String tc() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
