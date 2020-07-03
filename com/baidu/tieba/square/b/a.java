package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String lzb = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dgm() {
        setUrl(lzb);
        return getResult();
    }

    public long dgn() {
        if (this.byb != null) {
            return this.byb.aWu().aWX().dVs.KD;
        }
        return 0L;
    }

    public long dgo() {
        if (this.byb != null) {
            return this.byb.aWu().aWX().dVs.connectTime;
        }
        return 0L;
    }
}
