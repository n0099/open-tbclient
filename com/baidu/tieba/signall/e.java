package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String iWR = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cnd() {
        this.mNetWork = new x(iWR);
        this.mNetWork.o("authsid", this.mAuthSid);
        this.mNetWork.aiE().ajE().bUG = true;
        this.mNetWork.aiE().ajE().mIsNeedTbs = true;
        this.mNetWork.eb(true);
        return this.mNetWork.aig();
    }

    public String Eq(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(iWR);
        this.mNetWork.o("user_id", str2);
        this.mNetWork.o("forum_ids", str);
        this.mNetWork.o("authsid", this.mAuthSid);
        this.mNetWork.aiE().ajE().bUG = true;
        this.mNetWork.aiE().ajE().mIsNeedTbs = true;
        this.mNetWork.eb(true);
        return this.mNetWork.aig();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ik();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiE().ajF().isRequestSuccess();
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
