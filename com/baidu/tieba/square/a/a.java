package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes8.dex */
public class a extends d {
    private static final String jYU = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cHK() {
        setUrl(jYU);
        return getResult();
    }

    public long cHL() {
        if (this.cHA != null) {
            return this.cHA.aDU().aEw().cWJ.qM;
        }
        return 0L;
    }

    public long cHM() {
        if (this.cHA != null) {
            return this.cHA.aDU().aEw().cWJ.connectTime;
        }
        return 0L;
    }
}
