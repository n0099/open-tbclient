package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes24.dex */
public class e {
    private static final String mHT = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa bVi = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dEU() {
        this.bVi = new aa(mHT);
        this.bVi.addPostData("authsid", this.mAuthSid);
        this.bVi.bon().boT().mNeedBackgroundLogin = true;
        this.bVi.bon().boT().mIsNeedTbs = true;
        this.bVi.iR(true);
        return this.bVi.postNetData();
    }

    public String RW(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bVi = new aa(mHT);
        this.bVi.addPostData("user_id", str2);
        this.bVi.addPostData("forum_ids", str);
        this.bVi.addPostData("authsid", this.mAuthSid);
        this.bVi.bon().boT().mNeedBackgroundLogin = true;
        this.bVi.bon().boT().mIsNeedTbs = true;
        this.bVi.iR(true);
        return this.bVi.postNetData();
    }

    public void cancel() {
        if (this.bVi != null) {
            this.bVi.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bVi != null) {
            return this.bVi.bon().boU().isRequestSuccess();
        }
        return false;
    }

    public String bhf() {
        if (this.bVi != null) {
            return this.bVi.getErrorString();
        }
        return null;
    }
}
