package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String gMn = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String bvo() {
        this.mNetWork = new x(gMn);
        this.mNetWork.u("authsid", this.mAuthSid);
        this.mNetWork.zR().AP().auq = true;
        this.mNetWork.zR().AP().mIsNeedTbs = true;
        this.mNetWork.aR(true);
        return this.mNetWork.zt();
    }

    public String ua(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(gMn);
        this.mNetWork.u("user_id", str2);
        this.mNetWork.u("forum_ids", str);
        this.mNetWork.u("authsid", this.mAuthSid);
        this.mNetWork.zR().AP().auq = true;
        this.mNetWork.zR().AP().mIsNeedTbs = true;
        this.mNetWork.aR(true);
        return this.mNetWork.zt();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.iT();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.zR().AQ().isRequestSuccess();
        }
        return false;
    }

    public String uh() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
