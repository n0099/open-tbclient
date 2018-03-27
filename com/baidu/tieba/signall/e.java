package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String gRZ = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private x mNetWork = null;

    public String bty() {
        this.mNetWork = new x(gRZ);
        this.mNetWork.Cz().Dw().aYa = true;
        this.mNetWork.Cz().Dw().mIsNeedTbs = true;
        return this.mNetWork.Cb();
    }

    public String sq(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(gRZ);
        this.mNetWork.n("user_id", str2);
        this.mNetWork.n("forum_ids", str);
        this.mNetWork.Cz().Dw().aYa = true;
        this.mNetWork.Cz().Dw().mIsNeedTbs = true;
        return this.mNetWork.Cb();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.mS();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.Cz().Dx().isRequestSuccess();
        }
        return false;
    }

    public String xm() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
