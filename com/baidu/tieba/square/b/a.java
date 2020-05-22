package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String ldU = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dbI() {
        setUrl(ldU);
        return getResult();
    }

    public long dbJ() {
        if (this.bth != null) {
            return this.bth.aUA().aVc().dOA.Kc;
        }
        return 0L;
    }

    public long dbK() {
        if (this.bth != null) {
            return this.bth.aUA().aVc().dOA.connectTime;
        }
        return 0L;
    }
}
