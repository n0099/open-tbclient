package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String kJw = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x blF = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cTR() {
        this.blF = new x(kJw);
        this.blF.addPostData("authsid", this.mAuthSid);
        this.blF.aOy().aOZ().mNeedBackgroundLogin = true;
        this.blF.aOy().aOZ().mIsNeedTbs = true;
        this.blF.gI(true);
        return this.blF.postNetData();
    }

    public String Kl(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.blF = new x(kJw);
        this.blF.addPostData("user_id", str2);
        this.blF.addPostData("forum_ids", str);
        this.blF.addPostData("authsid", this.mAuthSid);
        this.blF.aOy().aOZ().mNeedBackgroundLogin = true;
        this.blF.aOy().aOZ().mIsNeedTbs = true;
        this.blF.gI(true);
        return this.blF.postNetData();
    }

    public void cancel() {
        if (this.blF != null) {
            this.blF.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.blF != null) {
            return this.blF.aOy().aPa().isRequestSuccess();
        }
        return false;
    }

    public String aIc() {
        if (this.blF != null) {
            return this.blF.getErrorString();
        }
        return null;
    }
}
