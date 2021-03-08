package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes7.dex */
public class e {
    private static final String nqh = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa cnM = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dLg() {
        this.cnM = new aa(nqh);
        this.cnM.addPostData("authsid", this.mAuthSid);
        this.cnM.bsu().btd().mNeedBackgroundLogin = true;
        this.cnM.bsu().btd().mIsNeedTbs = true;
        this.cnM.jL(true);
        return this.cnM.postNetData();
    }

    public String SS(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cnM = new aa(nqh);
        this.cnM.addPostData("user_id", str2);
        this.cnM.addPostData("forum_ids", str);
        this.cnM.addPostData("authsid", this.mAuthSid);
        this.cnM.bsu().btd().mNeedBackgroundLogin = true;
        this.cnM.bsu().btd().mIsNeedTbs = true;
        this.cnM.jL(true);
        return this.cnM.postNetData();
    }

    public void cancel() {
        if (this.cnM != null) {
            this.cnM.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cnM != null) {
            return this.cnM.bsu().bte().isRequestSuccess();
        }
        return false;
    }

    public String bkT() {
        if (this.cnM != null) {
            return this.cnM.getErrorString();
        }
        return null;
    }
}
