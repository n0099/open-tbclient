package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes7.dex */
public class e {
    private static final String ndT = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private z chV = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dIF() {
        this.chV = new z(ndT);
        this.chV.addPostData("authsid", this.mAuthSid);
        this.chV.brX().bsG().mNeedBackgroundLogin = true;
        this.chV.brX().bsG().mIsNeedTbs = true;
        this.chV.jI(true);
        return this.chV.postNetData();
    }

    public String RD(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.chV = new z(ndT);
        this.chV.addPostData("user_id", str2);
        this.chV.addPostData("forum_ids", str);
        this.chV.addPostData("authsid", this.mAuthSid);
        this.chV.brX().bsG().mNeedBackgroundLogin = true;
        this.chV.brX().bsG().mIsNeedTbs = true;
        this.chV.jI(true);
        return this.chV.postNetData();
    }

    public void cancel() {
        if (this.chV != null) {
            this.chV.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.chV != null) {
            return this.chV.brX().bsH().isRequestSuccess();
        }
        return false;
    }

    public String bkz() {
        if (this.chV != null) {
            return this.chV.getErrorString();
        }
        return null;
    }
}
