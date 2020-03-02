package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String jYv = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x cLE = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cIS() {
        this.cLE = new x(jYv);
        this.cLE.addPostData("authsid", this.mAuthSid);
        this.cLE.aGg().aGH().mNeedBackgroundLogin = true;
        this.cLE.aGg().aGH().mIsNeedTbs = true;
        this.cLE.fK(true);
        return this.cLE.postNetData();
    }

    public String IH(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cLE = new x(jYv);
        this.cLE.addPostData("user_id", str2);
        this.cLE.addPostData("forum_ids", str);
        this.cLE.addPostData("authsid", this.mAuthSid);
        this.cLE.aGg().aGH().mNeedBackgroundLogin = true;
        this.cLE.aGg().aGH().mIsNeedTbs = true;
        this.cLE.fK(true);
        return this.cLE.postNetData();
    }

    public void cancel() {
        if (this.cLE != null) {
            this.cLE.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cLE != null) {
            return this.cLE.aGg().aGI().isRequestSuccess();
        }
        return false;
    }

    public String azM() {
        if (this.cLE != null) {
            return this.cLE.getErrorString();
        }
        return null;
    }
}
