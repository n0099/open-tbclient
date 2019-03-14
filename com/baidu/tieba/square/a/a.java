package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String izw = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String ccH() {
        setUrl(izw);
        return getResult();
    }

    public long ccI() {
        if (this.mNetWork != null) {
            return this.mNetWork.acH().adH().bLU.CG;
        }
        return 0L;
    }

    public long ccJ() {
        if (this.mNetWork != null) {
            return this.mNetWork.acH().adH().bLU.connectTime;
        }
        return 0L;
    }
}
