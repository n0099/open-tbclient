package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String gTK = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String byD() {
        this.mNetWork = new x(gTK);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.BY().CW().azb = true;
        this.mNetWork.BY().CW().mIsNeedTbs = true;
        this.mNetWork.bb(true);
        return this.mNetWork.BA();
    }

    public String uC(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(gTK);
        this.mNetWork.x("user_id", str2);
        this.mNetWork.x("forum_ids", str);
        this.mNetWork.x("authsid", this.mAuthSid);
        this.mNetWork.BY().CW().azb = true;
        this.mNetWork.BY().CW().mIsNeedTbs = true;
        this.mNetWork.bb(true);
        return this.mNetWork.BA();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ji();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.BY().CX().isRequestSuccess();
        }
        return false;
    }

    public String wq() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
