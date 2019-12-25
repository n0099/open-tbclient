package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes8.dex */
public class e {
    private static final String jTN = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x cHo = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cGg() {
        this.cHo = new x(jTN);
        this.cHo.addPostData("authsid", this.mAuthSid);
        this.cHo.aDB().aEb().mNeedBackgroundLogin = true;
        this.cHo.aDB().aEb().mIsNeedTbs = true;
        this.cHo.fy(true);
        return this.cHo.postNetData();
    }

    public String Ij(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cHo = new x(jTN);
        this.cHo.addPostData("user_id", str2);
        this.cHo.addPostData("forum_ids", str);
        this.cHo.addPostData("authsid", this.mAuthSid);
        this.cHo.aDB().aEb().mNeedBackgroundLogin = true;
        this.cHo.aDB().aEb().mIsNeedTbs = true;
        this.cHo.fy(true);
        return this.cHo.postNetData();
    }

    public void cancel() {
        if (this.cHo != null) {
            this.cHo.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cHo != null) {
            return this.cHo.aDB().aEc().isRequestSuccess();
        }
        return false;
    }

    public String axd() {
        if (this.cHo != null) {
            return this.cHo.getErrorString();
        }
        return null;
    }
}
