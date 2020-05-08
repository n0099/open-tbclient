package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String kJA = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x blK = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cTO() {
        this.blK = new x(kJA);
        this.blK.addPostData("authsid", this.mAuthSid);
        this.blK.aOw().aOW().mNeedBackgroundLogin = true;
        this.blK.aOw().aOW().mIsNeedTbs = true;
        this.blK.gI(true);
        return this.blK.postNetData();
    }

    public String Ko(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.blK = new x(kJA);
        this.blK.addPostData("user_id", str2);
        this.blK.addPostData("forum_ids", str);
        this.blK.addPostData("authsid", this.mAuthSid);
        this.blK.aOw().aOW().mNeedBackgroundLogin = true;
        this.blK.aOw().aOW().mIsNeedTbs = true;
        this.blK.gI(true);
        return this.blK.postNetData();
    }

    public void cancel() {
        if (this.blK != null) {
            this.blK.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.blK != null) {
            return this.blK.aOw().aOX().isRequestSuccess();
        }
        return false;
    }

    public String aIa() {
        if (this.blK != null) {
            return this.blK.getErrorString();
        }
        return null;
    }
}
