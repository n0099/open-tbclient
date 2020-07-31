package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes18.dex */
public class e {
    private static final String lEn = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private z byq = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String diI() {
        this.byq = new z(lEn);
        this.byq.addPostData("authsid", this.mAuthSid);
        this.byq.bav().baW().mNeedBackgroundLogin = true;
        this.byq.bav().baW().mIsNeedTbs = true;
        this.byq.hO(true);
        return this.byq.postNetData();
    }

    public String Nl(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.byq = new z(lEn);
        this.byq.addPostData("user_id", str2);
        this.byq.addPostData("forum_ids", str);
        this.byq.addPostData("authsid", this.mAuthSid);
        this.byq.bav().baW().mNeedBackgroundLogin = true;
        this.byq.bav().baW().mIsNeedTbs = true;
        this.byq.hO(true);
        return this.byq.postNetData();
    }

    public void cancel() {
        if (this.byq != null) {
            this.byq.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.byq != null) {
            return this.byq.bav().baX().isRequestSuccess();
        }
        return false;
    }

    public String aTt() {
        if (this.byq != null) {
            return this.byq.getErrorString();
        }
        return null;
    }
}
