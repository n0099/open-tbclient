package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes23.dex */
public class e {
    private static final String mOL = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa bZh = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dHn() {
        this.bZh = new aa(mOL);
        this.bZh.addPostData("authsid", this.mAuthSid);
        this.bZh.bqa().bqH().mNeedBackgroundLogin = true;
        this.bZh.bqa().bqH().mIsNeedTbs = true;
        this.bZh.jb(true);
        return this.bZh.postNetData();
    }

    public String RO(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bZh = new aa(mOL);
        this.bZh.addPostData("user_id", str2);
        this.bZh.addPostData("forum_ids", str);
        this.bZh.addPostData("authsid", this.mAuthSid);
        this.bZh.bqa().bqH().mNeedBackgroundLogin = true;
        this.bZh.bqa().bqH().mIsNeedTbs = true;
        this.bZh.jb(true);
        return this.bZh.postNetData();
    }

    public void cancel() {
        if (this.bZh != null) {
            this.bZh.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bZh != null) {
            return this.bZh.bqa().bqI().isRequestSuccess();
        }
        return false;
    }

    public String biJ() {
        if (this.bZh != null) {
            return this.bZh.getErrorString();
        }
        return null;
    }
}
