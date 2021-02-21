package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes8.dex */
public class e {
    private static final String nob = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa cml = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dKY() {
        this.cml = new aa(nob);
        this.cml.addPostData("authsid", this.mAuthSid);
        this.cml.bsr().bta().mNeedBackgroundLogin = true;
        this.cml.bsr().bta().mIsNeedTbs = true;
        this.cml.jL(true);
        return this.cml.postNetData();
    }

    public String SM(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cml = new aa(nob);
        this.cml.addPostData("user_id", str2);
        this.cml.addPostData("forum_ids", str);
        this.cml.addPostData("authsid", this.mAuthSid);
        this.cml.bsr().bta().mNeedBackgroundLogin = true;
        this.cml.bsr().bta().mIsNeedTbs = true;
        this.cml.jL(true);
        return this.cml.postNetData();
    }

    public void cancel() {
        if (this.cml != null) {
            this.cml.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cml != null) {
            return this.cml.bsr().btb().isRequestSuccess();
        }
        return false;
    }

    public String bkR() {
        if (this.cml != null) {
            return this.cml.getErrorString();
        }
        return null;
    }
}
