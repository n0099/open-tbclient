package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes11.dex */
public class e {
    private static final String jYt = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private x cLD = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String cIQ() {
        this.cLD = new x(jYt);
        this.cLD.addPostData("authsid", this.mAuthSid);
        this.cLD.aGe().aGF().mNeedBackgroundLogin = true;
        this.cLD.aGe().aGF().mIsNeedTbs = true;
        this.cLD.fK(true);
        return this.cLD.postNetData();
    }

    public String IH(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cLD = new x(jYt);
        this.cLD.addPostData("user_id", str2);
        this.cLD.addPostData("forum_ids", str);
        this.cLD.addPostData("authsid", this.mAuthSid);
        this.cLD.aGe().aGF().mNeedBackgroundLogin = true;
        this.cLD.aGe().aGF().mIsNeedTbs = true;
        this.cLD.fK(true);
        return this.cLD.postNetData();
    }

    public void cancel() {
        if (this.cLD != null) {
            this.cLD.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cLD != null) {
            return this.cLD.aGe().aGG().isRequestSuccess();
        }
        return false;
    }

    public String azK() {
        if (this.cLD != null) {
            return this.cLD.getErrorString();
        }
        return null;
    }
}
