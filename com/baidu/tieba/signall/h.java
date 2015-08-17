package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class h {
    private static final String cAw = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.v Tu = null;

    public String kb(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.Tu = new com.baidu.tbadk.core.util.v(cAw);
        this.Tu.o("user_id", str2);
        this.Tu.o("forum_ids", str);
        this.Tu.ue().uV().abE = true;
        this.Tu.ue().uV().mIsNeedTbs = true;
        return this.Tu.tD();
    }

    public void cancel() {
        if (this.Tu != null) {
            this.Tu.gM();
        }
    }

    public boolean rb() {
        if (this.Tu != null) {
            return this.Tu.ue().uW().rb();
        }
        return false;
    }

    public String rc() {
        if (this.Tu != null) {
            return this.Tu.getErrorString();
        }
        return null;
    }
}
