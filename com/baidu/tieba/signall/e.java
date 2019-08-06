package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String iXV = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cnv() {
        this.mNetWork = new x(iXV);
        this.mNetWork.o("authsid", this.mAuthSid);
        this.mNetWork.aiG().ajG().bUM = true;
        this.mNetWork.aiG().ajG().mIsNeedTbs = true;
        this.mNetWork.eb(true);
        return this.mNetWork.aii();
    }

    public String Er(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(iXV);
        this.mNetWork.o("user_id", str2);
        this.mNetWork.o("forum_ids", str);
        this.mNetWork.o("authsid", this.mAuthSid);
        this.mNetWork.aiG().ajG().bUM = true;
        this.mNetWork.aiG().ajG().mIsNeedTbs = true;
        this.mNetWork.eb(true);
        return this.mNetWork.aii();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ik();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiG().ajH().isRequestSuccess();
        }
        return false;
    }

    public String abY() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
