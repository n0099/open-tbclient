package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String kLA = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cUG() {
        setUrl(kLA);
        return getResult();
    }

    public long cUH() {
        if (this.blF != null) {
            return this.blF.aOy().aPb().dAq.JN;
        }
        return 0L;
    }

    public long cUI() {
        if (this.blF != null) {
            return this.blF.aOy().aPb().dAq.connectTime;
        }
        return 0L;
    }
}
