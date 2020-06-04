package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String lcZ = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x bth = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dbj() {
        this.bth = new x(lcZ);
        this.bth.addPostData("authsid", this.mAuthSid);
        this.bth.aUA().aVb().mNeedBackgroundLogin = true;
        this.bth.aUA().aVb().mIsNeedTbs = true;
        this.bth.ha(true);
        return this.bth.postNetData();
    }

    public String Mb(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bth = new x(lcZ);
        this.bth.addPostData("user_id", str2);
        this.bth.addPostData("forum_ids", str);
        this.bth.addPostData("authsid", this.mAuthSid);
        this.bth.aUA().aVb().mNeedBackgroundLogin = true;
        this.bth.aUA().aVb().mIsNeedTbs = true;
        this.bth.ha(true);
        return this.bth.postNetData();
    }

    public void cancel() {
        if (this.bth != null) {
            this.bth.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bth != null) {
            return this.bth.aUA().aVc().isRequestSuccess();
        }
        return false;
    }

    public String aNO() {
        if (this.bth != null) {
            return this.bth.getErrorString();
        }
        return null;
    }
}
