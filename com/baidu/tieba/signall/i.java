package com.baidu.tieba.signall;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class i {
    private static final String cii = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/msign";
    private com.baidu.tbadk.core.util.aa OE = null;

    public String jf(String str) {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str2 = null;
        if (currentAccountObj != null) {
            str2 = currentAccountObj.getID();
        }
        this.OE = new com.baidu.tbadk.core.util.aa(cii);
        this.OE.o("user_id", str2);
        this.OE.o("forum_ids", str);
        this.OE.sX().tS().WD = true;
        this.OE.sX().tS().mIsNeedTbs = true;
        return this.OE.sw();
    }

    public void cancel() {
        if (this.OE != null) {
            this.OE.gS();
        }
    }

    public boolean qa() {
        if (this.OE != null) {
            return this.OE.sX().tT().qa();
        }
        return false;
    }

    public String qb() {
        if (this.OE != null) {
            return this.OE.getErrorString();
        }
        return null;
    }
}
