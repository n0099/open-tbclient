package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes6.dex */
public class e {
    private static final String iQu = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private String mAuthSid;
    private x mNetWork = null;

    public void setAuthSid(String str) {
        this.mAuthSid = str;
    }

    public String ckj() {
        this.mNetWork = new x(iQu);
        this.mNetWork.o("authsid", this.mAuthSid);
        this.mNetWork.ahC().aiB().bTE = true;
        this.mNetWork.ahC().aiB().mIsNeedTbs = true;
        this.mNetWork.dX(true);
        return this.mNetWork.ahe();
    }

    public String DB(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(iQu);
        this.mNetWork.o("user_id", str2);
        this.mNetWork.o("forum_ids", str);
        this.mNetWork.o("authsid", this.mAuthSid);
        this.mNetWork.ahC().aiB().bTE = true;
        this.mNetWork.ahC().aiB().mIsNeedTbs = true;
        this.mNetWork.dX(true);
        return this.mNetWork.ahe();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.ia();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.ahC().aiC().isRequestSuccess();
        }
        return false;
    }

    public String aaZ() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
