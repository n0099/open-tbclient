package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String kLE = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cUE() {
        setUrl(kLE);
        return getResult();
    }

    public long cUF() {
        if (this.blK != null) {
            return this.blK.aOw().aOY().dAu.JQ;
        }
        return 0L;
    }

    public long cUG() {
        if (this.blK != null) {
            return this.blK.aOw().aOY().dAu.connectTime;
        }
        return 0L;
    }
}
