package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes24.dex */
public class e {
    private static final String ncR = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa cfI = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dMD() {
        this.cfI = new aa(ncR);
        this.cfI.addPostData("authsid", this.mAuthSid);
        this.cfI.btv().bue().mNeedBackgroundLogin = true;
        this.cfI.btv().bue().mIsNeedTbs = true;
        this.cfI.jq(true);
        return this.cfI.postNetData();
    }

    public String Tc(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cfI = new aa(ncR);
        this.cfI.addPostData("user_id", str2);
        this.cfI.addPostData("forum_ids", str);
        this.cfI.addPostData("authsid", this.mAuthSid);
        this.cfI.btv().bue().mNeedBackgroundLogin = true;
        this.cfI.btv().bue().mIsNeedTbs = true;
        this.cfI.jq(true);
        return this.cfI.postNetData();
    }

    public void cancel() {
        if (this.cfI != null) {
            this.cfI.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cfI != null) {
            return this.cfI.btv().buf().isRequestSuccess();
        }
        return false;
    }

    public String blT() {
        if (this.cfI != null) {
            return this.cfI.getErrorString();
        }
        return null;
    }
}
