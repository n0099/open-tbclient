package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String dqh = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.ab Ty = null;

    public String lZ(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Ty = new com.baidu.tbadk.core.util.ab(dqh);
        this.Ty.o("user_id", str2);
        this.Ty.o("forum_ids", str);
        this.Ty.uM().vF().acL = true;
        this.Ty.uM().vF().mIsNeedTbs = true;
        return this.Ty.ul();
    }

    public void cancel() {
        if (this.Ty != null) {
            this.Ty.gL();
        }
    }

    public boolean rf() {
        if (this.Ty != null) {
            return this.Ty.uM().vG().rf();
        }
        return false;
    }

    public String rg() {
        if (this.Ty != null) {
            return this.Ty.getErrorString();
        }
        return null;
    }
}
