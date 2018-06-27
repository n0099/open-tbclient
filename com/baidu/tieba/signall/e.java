package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes3.dex */
public class e {
    private static final String gDz = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private y mNetWork = null;

    public String buf() {
        this.mNetWork = new y(gDz);
        this.mNetWork.yX().zX().aso = true;
        this.mNetWork.yX().zX().mIsNeedTbs = true;
        return this.mNetWork.yz();
    }

    public String tr(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new y(gDz);
        this.mNetWork.o("user_id", str2);
        this.mNetWork.o("forum_ids", str);
        this.mNetWork.yX().zX().aso = true;
        this.mNetWork.yX().zX().mIsNeedTbs = true;
        return this.mNetWork.yz();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.hN();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.yX().zY().isRequestSuccess();
        }
        return false;
    }

    public String tr() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
