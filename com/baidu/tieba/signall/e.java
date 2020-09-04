package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes18.dex */
public class e {
    private static final String lWi = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa bEb = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dui() {
        this.bEb = new aa(lWi);
        this.bEb.addPostData("authsid", this.mAuthSid);
        this.bEb.biQ().bjv().mNeedBackgroundLogin = true;
        this.bEb.biQ().bjv().mIsNeedTbs = true;
        this.bEb.il(true);
        return this.bEb.postNetData();
    }

    public String Qj(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bEb = new aa(lWi);
        this.bEb.addPostData("user_id", str2);
        this.bEb.addPostData("forum_ids", str);
        this.bEb.addPostData("authsid", this.mAuthSid);
        this.bEb.biQ().bjv().mNeedBackgroundLogin = true;
        this.bEb.biQ().bjv().mIsNeedTbs = true;
        this.bEb.il(true);
        return this.bEb.postNetData();
    }

    public void cancel() {
        if (this.bEb != null) {
            this.bEb.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bEb != null) {
            return this.bEb.biQ().bjw().isRequestSuccess();
        }
        return false;
    }

    public String bbK() {
        if (this.bEb != null) {
            return this.bEb.getErrorString();
        }
        return null;
    }
}
