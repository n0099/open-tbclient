package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String gRJ = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private x mNetWork = null;

    public String btx() {
        this.mNetWork = new x(gRJ);
        this.mNetWork.Cy().Dv().aXY = true;
        this.mNetWork.Cy().Dv().mIsNeedTbs = true;
        return this.mNetWork.Ca();
    }

    public String sq(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(gRJ);
        this.mNetWork.n("user_id", str2);
        this.mNetWork.n("forum_ids", str);
        this.mNetWork.Cy().Dv().aXY = true;
        this.mNetWork.Cy().Dv().mIsNeedTbs = true;
        return this.mNetWork.Ca();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.mS();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.Cy().Dw().isRequestSuccess();
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
