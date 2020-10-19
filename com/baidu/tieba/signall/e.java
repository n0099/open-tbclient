package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes24.dex */
public class e {
    private static final String mvn = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa bML = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dBM() {
        this.bML = new aa(mvn);
        this.bML.addPostData("authsid", this.mAuthSid);
        this.bML.bmu().bna().mNeedBackgroundLogin = true;
        this.bML.bmu().bna().mIsNeedTbs = true;
        this.bML.iE(true);
        return this.bML.postNetData();
    }

    public String Rx(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bML = new aa(mvn);
        this.bML.addPostData("user_id", str2);
        this.bML.addPostData("forum_ids", str);
        this.bML.addPostData("authsid", this.mAuthSid);
        this.bML.bmu().bna().mNeedBackgroundLogin = true;
        this.bML.bmu().bna().mIsNeedTbs = true;
        this.bML.iE(true);
        return this.bML.postNetData();
    }

    public void cancel() {
        if (this.bML != null) {
            this.bML.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bML != null) {
            return this.bML.bmu().bnb().isRequestSuccess();
        }
        return false;
    }

    public String bfm() {
        if (this.bML != null) {
            return this.bML.getErrorString();
        }
        return null;
    }
}
