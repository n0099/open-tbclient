package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String lfe = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dbX() {
        setUrl(lfe);
        return getResult();
    }

    public long dbY() {
        if (this.bth != null) {
            return this.bth.aUA().aVd().dOA.Kc;
        }
        return 0L;
    }

    public long dbZ() {
        if (this.bth != null) {
            return this.bth.aUA().aVd().dOA.connectTime;
        }
        return 0L;
    }
}
