package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String hgm = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String bBr() {
        this.mNetWork = new x(hgm);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.Dw().Eu().aDU = true;
        this.mNetWork.Dw().Eu().mIsNeedTbs = true;
        this.mNetWork.bt(true);
        return this.mNetWork.CY();
    }

    public String vA(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(hgm);
        this.mNetWork.x("user_id", str2);
        this.mNetWork.x("forum_ids", str);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.Dw().Eu().aDU = true;
        this.mNetWork.Dw().Eu().mIsNeedTbs = true;
        this.mNetWork.bt(true);
        return this.mNetWork.CY();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.jg();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.Dw().Ev().isRequestSuccess();
        }
        return false;
    }

    public String xP() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
