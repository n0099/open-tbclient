package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes8.dex */
public class a extends d {
    private static final String npJ = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dLG() {
        setUrl(npJ);
        return getResult();
    }

    public long dLH() {
        if (this.cml != null) {
            return this.cml.bsr().btc().fbP.Ma;
        }
        return 0L;
    }

    public long dLI() {
        if (this.cml != null) {
            return this.cml.bsr().btc().fbP.connectTime;
        }
        return 0L;
    }
}
