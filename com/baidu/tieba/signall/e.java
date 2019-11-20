package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String iZr = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x bUY = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String clW() {
        this.bUY = new x(iZr);
        this.bUY.addPostData("authsid", this.mAuthSid);
        this.bUY.amp().amP().mNeedBackgroundLogin = true;
        this.bUY.amp().amP().mIsNeedTbs = true;
        this.bUY.ek(true);
        return this.bUY.postNetData();
    }

    public String Dw(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bUY = new x(iZr);
        this.bUY.addPostData("user_id", str2);
        this.bUY.addPostData("forum_ids", str);
        this.bUY.addPostData("authsid", this.mAuthSid);
        this.bUY.amp().amP().mNeedBackgroundLogin = true;
        this.bUY.amp().amP().mIsNeedTbs = true;
        this.bUY.ek(true);
        return this.bUY.postNetData();
    }

    public void cancel() {
        if (this.bUY != null) {
            this.bUY.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bUY != null) {
            return this.bUY.amp().amQ().isRequestSuccess();
        }
        return false;
    }

    public String agm() {
        if (this.bUY != null) {
            return this.bUY.getErrorString();
        }
        return null;
    }
}
