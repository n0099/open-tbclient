package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String jYH = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x cLF = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cIT() {
        this.cLF = new x(jYH);
        this.cLF.addPostData("authsid", this.mAuthSid);
        this.cLF.aGg().aGH().mNeedBackgroundLogin = true;
        this.cLF.aGg().aGH().mIsNeedTbs = true;
        this.cLF.fK(true);
        return this.cLF.postNetData();
    }

    public String II(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cLF = new x(jYH);
        this.cLF.addPostData("user_id", str2);
        this.cLF.addPostData("forum_ids", str);
        this.cLF.addPostData("authsid", this.mAuthSid);
        this.cLF.aGg().aGH().mNeedBackgroundLogin = true;
        this.cLF.aGg().aGH().mIsNeedTbs = true;
        this.cLF.fK(true);
        return this.cLF.postNetData();
    }

    public void cancel() {
        if (this.cLF != null) {
            this.cLF.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cLF != null) {
            return this.cLF.aGg().aGI().isRequestSuccess();
        }
        return false;
    }

    public String azM() {
        if (this.cLF != null) {
            return this.cLF.getErrorString();
        }
        return null;
    }
}
