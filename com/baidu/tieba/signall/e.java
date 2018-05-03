package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String gnc = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private x mNetWork = null;

    public String boH() {
        this.mNetWork = new x(gnc);
        this.mNetWork.vj().wi().ajD = true;
        this.mNetWork.vj().wi().mIsNeedTbs = true;
        return this.mNetWork.uL();
    }

    public String sy(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(gnc);
        this.mNetWork.n("user_id", str2);
        this.mNetWork.n("forum_ids", str);
        this.mNetWork.vj().wi().ajD = true;
        this.mNetWork.vj().wi().mIsNeedTbs = true;
        return this.mNetWork.uL();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.eW();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.vj().wj().isRequestSuccess();
        }
        return false;
    }

    public String pW() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
