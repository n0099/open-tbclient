package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes23.dex */
public class a extends d {
    private static final String mQa = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dIm() {
        setUrl(mQa);
        return getResult();
    }

    public long dIn() {
        if (this.caS != null) {
            return this.caS.bqN().brv().eOq.LJ;
        }
        return 0L;
    }

    public long dIo() {
        if (this.caS != null) {
            return this.caS.bqN().brv().eOq.connectTime;
        }
        return 0L;
    }
}
