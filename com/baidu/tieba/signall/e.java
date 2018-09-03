package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes3.dex */
public class e {
    private static final String gEK = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private y mNetWork = null;

    public String bsJ() {
        this.mNetWork = new y(gEK);
        this.mNetWork.yM().zK().arS = true;
        this.mNetWork.yM().zK().mIsNeedTbs = true;
        return this.mNetWork.yo();
    }

    public String tt(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new y(gEK);
        this.mNetWork.o("user_id", str2);
        this.mNetWork.o("forum_ids", str);
        this.mNetWork.yM().zK().arS = true;
        this.mNetWork.yM().zK().mIsNeedTbs = true;
        return this.mNetWork.yo();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.hN();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.yM().zL().isRequestSuccess();
        }
        return false;
    }

    public String tb() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
