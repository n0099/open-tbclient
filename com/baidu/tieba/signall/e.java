package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes9.dex */
public class e {
    private static final String jXu = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x cHA = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cHm() {
        this.cHA = new x(jXu);
        this.cHA.addPostData("authsid", this.mAuthSid);
        this.cHA.aDU().aEu().mNeedBackgroundLogin = true;
        this.cHA.aDU().aEu().mIsNeedTbs = true;
        this.cHA.fD(true);
        return this.cHA.postNetData();
    }

    public String It(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cHA = new x(jXu);
        this.cHA.addPostData("user_id", str2);
        this.cHA.addPostData("forum_ids", str);
        this.cHA.addPostData("authsid", this.mAuthSid);
        this.cHA.aDU().aEu().mNeedBackgroundLogin = true;
        this.cHA.aDU().aEu().mIsNeedTbs = true;
        this.cHA.fD(true);
        return this.cHA.postNetData();
    }

    public void cancel() {
        if (this.cHA != null) {
            this.cHA.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cHA != null) {
            return this.cHA.aDU().aEv().isRequestSuccess();
        }
        return false;
    }

    public String axw() {
        if (this.cHA != null) {
            return this.cHA.getErrorString();
        }
        return null;
    }
}
