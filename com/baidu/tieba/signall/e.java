package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes11.dex */
public class e {
    private static final String lwW = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private y byb = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dfy() {
        this.byb = new y(lwW);
        this.byb.addPostData("authsid", this.mAuthSid);
        this.byb.aWu().aWV().mNeedBackgroundLogin = true;
        this.byb.aWu().aWV().mIsNeedTbs = true;
        this.byb.hj(true);
        return this.byb.postNetData();
    }

    public String MD(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.byb = new y(lwW);
        this.byb.addPostData("user_id", str2);
        this.byb.addPostData("forum_ids", str);
        this.byb.addPostData("authsid", this.mAuthSid);
        this.byb.aWu().aWV().mNeedBackgroundLogin = true;
        this.byb.aWu().aWV().mIsNeedTbs = true;
        this.byb.hj(true);
        return this.byb.postNetData();
    }

    public void cancel() {
        if (this.byb != null) {
            this.byb.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.byb != null) {
            return this.byb.aWu().aWW().isRequestSuccess();
        }
        return false;
    }

    public String aPy() {
        if (this.byb != null) {
            return this.byb.getErrorString();
        }
        return null;
    }
}
