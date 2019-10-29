package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String jai = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x bVP = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String clY() {
        this.bVP = new x(jai);
        this.bVP.addPostData("authsid", this.mAuthSid);
        this.bVP.amr().amR().mNeedBackgroundLogin = true;
        this.bVP.amr().amR().mIsNeedTbs = true;
        this.bVP.ek(true);
        return this.bVP.postNetData();
    }

    public String Dw(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bVP = new x(jai);
        this.bVP.addPostData("user_id", str2);
        this.bVP.addPostData("forum_ids", str);
        this.bVP.addPostData("authsid", this.mAuthSid);
        this.bVP.amr().amR().mNeedBackgroundLogin = true;
        this.bVP.amr().amR().mIsNeedTbs = true;
        this.bVP.ek(true);
        return this.bVP.postNetData();
    }

    public void cancel() {
        if (this.bVP != null) {
            this.bVP.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bVP != null) {
            return this.bVP.amr().amS().isRequestSuccess();
        }
        return false;
    }

    public String ago() {
        if (this.bVP != null) {
            return this.bVP.getErrorString();
        }
        return null;
    }
}
