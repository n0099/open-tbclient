package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes23.dex */
public class a extends d {
    private static final String mxt = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dCC() {
        setUrl(mxt);
        return getResult();
    }

    public long dCD() {
        if (this.bML != null) {
            return this.bML.bmu().bnc().eAf.LI;
        }
        return 0L;
    }

    public long dCE() {
        if (this.bML != null) {
            return this.bML.bmu().bnc().eAf.connectTime;
        }
        return 0L;
    }
}
