package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes18.dex */
public class e {
    private static final String lVT = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private aa bDY = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dud() {
        this.bDY = new aa(lVT);
        this.bDY.addPostData("authsid", this.mAuthSid);
        this.bDY.biQ().bjv().mNeedBackgroundLogin = true;
        this.bDY.biQ().bjv().mIsNeedTbs = true;
        this.bDY.ik(true);
        return this.bDY.postNetData();
    }

    public String Qj(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.bDY = new aa(lVT);
        this.bDY.addPostData("user_id", str2);
        this.bDY.addPostData("forum_ids", str);
        this.bDY.addPostData("authsid", this.mAuthSid);
        this.bDY.biQ().bjv().mNeedBackgroundLogin = true;
        this.bDY.biQ().bjv().mIsNeedTbs = true;
        this.bDY.ik(true);
        return this.bDY.postNetData();
    }

    public void cancel() {
        if (this.bDY != null) {
            this.bDY.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.bDY != null) {
            return this.bDY.biQ().bjw().isRequestSuccess();
        }
        return false;
    }

    public String bbK() {
        if (this.bDY != null) {
            return this.bDY.getErrorString();
        }
        return null;
    }
}
