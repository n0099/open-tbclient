package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes22.dex */
public class a extends d {
    private static final String mhQ = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dyR() {
        setUrl(mhQ);
        return getResult();
    }

    public long dyS() {
        if (this.bGb != null) {
            return this.bGb.bjL().bks().enS.Lq;
        }
        return 0L;
    }

    public long dyT() {
        if (this.bGb != null) {
            return this.bGb.bjL().bks().enS.connectTime;
        }
        return 0L;
    }
}
