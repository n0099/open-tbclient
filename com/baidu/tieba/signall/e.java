package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes24.dex */
public class e {
    private static final String mNS = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa caS = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dHw() {
        this.caS = new aa(mNS);
        this.caS.addPostData("authsid", this.mAuthSid);
        this.caS.bqN().brt().mNeedBackgroundLogin = true;
        this.caS.bqN().brt().mIsNeedTbs = true;
        this.caS.ja(true);
        return this.caS.postNetData();
    }

    public String Sn(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.caS = new aa(mNS);
        this.caS.addPostData("user_id", str2);
        this.caS.addPostData("forum_ids", str);
        this.caS.addPostData("authsid", this.mAuthSid);
        this.caS.bqN().brt().mNeedBackgroundLogin = true;
        this.caS.bqN().brt().mIsNeedTbs = true;
        this.caS.ja(true);
        return this.caS.postNetData();
    }

    public void cancel() {
        if (this.caS != null) {
            this.caS.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.caS != null) {
            return this.caS.bqN().bru().isRequestSuccess();
        }
        return false;
    }

    public String bjF() {
        if (this.caS != null) {
            return this.caS.getErrorString();
        }
        return null;
    }
}
