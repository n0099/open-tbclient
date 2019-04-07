package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String ixG = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cce() {
        this.mNetWork = new x(ixG);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.acE().adC().bLS = true;
        this.mNetWork.acE().adC().mIsNeedTbs = true;
        this.mNetWork.dB(true);
        return this.mNetWork.acg();
    }

    public String Cf(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(ixG);
        this.mNetWork.x("user_id", str2);
        this.mNetWork.x("forum_ids", str);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.acE().adC().bLS = true;
        this.mNetWork.acE().adC().mIsNeedTbs = true;
        this.mNetWork.dB(true);
        return this.mNetWork.acg();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ji();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.acE().adD().isRequestSuccess();
        }
        return false;
    }

    public String Wt() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
