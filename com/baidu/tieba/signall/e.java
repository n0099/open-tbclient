package com.baidu.tieba.signall;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes8.dex */
public class e {
    private static final String niA = TbConfig.SERVER_ADDRESS + Config.M_SIGN;
    private z cmJ = null;
    private String mAuthSid;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String dMw() {
        this.cmJ = new z(niA);
        this.cmJ.addPostData("authsid", this.mAuthSid);
        this.cmJ.bvQ().bwz().mNeedBackgroundLogin = true;
        this.cmJ.bvQ().bwz().mIsNeedTbs = true;
        this.cmJ.jM(true);
        return this.cmJ.postNetData();
    }

    public String SL(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.cmJ = new z(niA);
        this.cmJ.addPostData("user_id", str2);
        this.cmJ.addPostData("forum_ids", str);
        this.cmJ.addPostData("authsid", this.mAuthSid);
        this.cmJ.bvQ().bwz().mNeedBackgroundLogin = true;
        this.cmJ.bvQ().bwz().mIsNeedTbs = true;
        this.cmJ.jM(true);
        return this.cmJ.postNetData();
    }

    public void cancel() {
        if (this.cmJ != null) {
            this.cmJ.cancelNetConnect();
        }
    }

    public boolean isRequestSuccess() {
        if (this.cmJ != null) {
            return this.cmJ.bvQ().bwA().isRequestSuccess();
        }
        return false;
    }

    public String bos() {
        if (this.cmJ != null) {
            return this.cmJ.getErrorString();
        }
        return null;
    }
}
