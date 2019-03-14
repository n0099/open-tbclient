package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String ixW = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cci() {
        this.mNetWork = new x(ixW);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.acH().adF().bLQ = true;
        this.mNetWork.acH().adF().mIsNeedTbs = true;
        this.mNetWork.dB(true);
        return this.mNetWork.acj();
    }

    public String Cg(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(ixW);
        this.mNetWork.x("user_id", str2);
        this.mNetWork.x("forum_ids", str);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.acH().adF().bLQ = true;
        this.mNetWork.acH().adF().mIsNeedTbs = true;
        this.mNetWork.dB(true);
        return this.mNetWork.acj();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ji();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.acH().adG().isRequestSuccess();
        }
        return false;
    }

    public String Ww() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
