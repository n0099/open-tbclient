package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes23.dex */
public class e {
    private static final String mfK = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa bGb = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dyb() {
        this.bGb = new aa(mfK);
        this.bGb.addPostData("authsid", this.mAuthSid);
        this.bGb.bjL().bkq().mNeedBackgroundLogin = true;
        this.bGb.bjL().bkq().mIsNeedTbs = true;
        this.bGb.ii(true);
        return this.bGb.postNetData();
    }

    public String QJ(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bGb = new aa(mfK);
        this.bGb.addPostData("user_id", str2);
        this.bGb.addPostData("forum_ids", str);
        this.bGb.addPostData("authsid", this.mAuthSid);
        this.bGb.bjL().bkq().mNeedBackgroundLogin = true;
        this.bGb.bjL().bkq().mIsNeedTbs = true;
        this.bGb.ii(true);
        return this.bGb.postNetData();
    }

    public void cancel() {
        if (this.bGb != null) {
            this.bGb.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bGb != null) {
            return this.bGb.bjL().bkr().isRequestSuccess();
        }
        return false;
    }

    public String bcE() {
        if (this.bGb != null) {
            return this.bGb.getErrorString();
        }
        return null;
    }
}
