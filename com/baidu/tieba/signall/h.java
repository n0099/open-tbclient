package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String dNy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.aa Ty = null;

    public String mn(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Ty = new com.baidu.tbadk.core.util.aa(dNy);
        this.Ty.p("user_id", str2);
        this.Ty.p("forum_ids", str);
        this.Ty.vB().wv().adM = true;
        this.Ty.vB().wv().mIsNeedTbs = true;
        return this.Ty.uZ();
    }

    public void cancel() {
        if (this.Ty != null) {
            this.Ty.gT();
        }
    }

    public boolean rl() {
        if (this.Ty != null) {
            return this.Ty.vB().ww().rl();
        }
        return false;
    }

    public String rm() {
        if (this.Ty != null) {
            return this.Ty.getErrorString();
        }
        return null;
    }
}
