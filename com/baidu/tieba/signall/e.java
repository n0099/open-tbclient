package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String hfh = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String bAI() {
        this.mNetWork = new x(hfh);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.Dj().Eh().aDr = true;
        this.mNetWork.Dj().Eh().mIsNeedTbs = true;
        this.mNetWork.bs(true);
        return this.mNetWork.CL();
    }

    public String vk(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(hfh);
        this.mNetWork.x("user_id", str2);
        this.mNetWork.x("forum_ids", str);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.Dj().Eh().aDr = true;
        this.mNetWork.Dj().Eh().mIsNeedTbs = true;
        this.mNetWork.bs(true);
        return this.mNetWork.CL();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.jg();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.Dj().Ei().isRequestSuccess();
        }
        return false;
    }

    public String xC() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
