package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes3.dex */
public class e {
    private static final String goi = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    private x mNetWork = null;

    public String boF() {
        this.mNetWork = new x(goi);
        this.mNetWork.vi().wh().ajD = true;
        this.mNetWork.vi().wh().mIsNeedTbs = true;
        return this.mNetWork.uK();
    }

    public String sB(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.mNetWork = new x(goi);
        this.mNetWork.n("user_id", str2);
        this.mNetWork.n("forum_ids", str);
        this.mNetWork.vi().wh().ajD = true;
        this.mNetWork.vi().wh().mIsNeedTbs = true;
        return this.mNetWork.uK();
    }

    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.eW();
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetWork != null) {
            return this.mNetWork.vi().wi().isRequestSuccess();
        }
        return false;
    }

    public String pV() {
        if (this.mNetWork != null) {
            return this.mNetWork.getErrorString();
        }
        return null;
    }
}
