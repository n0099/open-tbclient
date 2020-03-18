package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String kaj = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x cLQ = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cJn() {
        this.cLQ = new x(kaj);
        this.cLQ.addPostData("authsid", this.mAuthSid);
        this.cLQ.aGk().aGL().mNeedBackgroundLogin = true;
        this.cLQ.aGk().aGL().mIsNeedTbs = true;
        this.cLQ.fL(true);
        return this.cLQ.postNetData();
    }

    public String IH(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cLQ = new x(kaj);
        this.cLQ.addPostData("user_id", str2);
        this.cLQ.addPostData("forum_ids", str);
        this.cLQ.addPostData("authsid", this.mAuthSid);
        this.cLQ.aGk().aGL().mNeedBackgroundLogin = true;
        this.cLQ.aGk().aGL().mIsNeedTbs = true;
        this.cLQ.fL(true);
        return this.cLQ.postNetData();
    }

    public void cancel() {
        if (this.cLQ != null) {
            this.cLQ.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cLQ != null) {
            return this.cLQ.aGk().aGM().isRequestSuccess();
        }
        return false;
    }

    public String azP() {
        if (this.cLQ != null) {
            return this.cLQ.getErrorString();
        }
        return null;
    }
}
