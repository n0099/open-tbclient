package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String eji = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ab LL = null;

    public String aQm() {
        this.LL = new com.baidu.tbadk.core.util.ab(eji);
        this.LL.tB().uv().YA = true;
        this.LL.tB().uv().mIsNeedTbs = true;
        return this.LL.td();
    }

    public String nx(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.LL = new com.baidu.tbadk.core.util.ab(eji);
        this.LL.n("user_id", str2);
        this.LL.n("forum_ids", str);
        this.LL.tB().uv().YA = true;
        this.LL.tB().uv().mIsNeedTbs = true;
        return this.LL.td();
    }

    public void cancel() {
        if (this.LL != null) {
            this.LL.dl();
        }
    }

    public boolean nZ() {
        if (this.LL != null) {
            return this.LL.tB().uw().nZ();
        }
        return false;
    }

    public String oa() {
        if (this.LL != null) {
            return this.LL.getErrorString();
        }
        return null;
    }
}
