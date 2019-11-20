package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String jaQ = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cmv() {
        setUrl(jaQ);
        return getResult();
    }

    public long cmw() {
        if (this.bUY != null) {
            return this.bUY.amp().amR().cjO.ov;
        }
        return 0L;
    }

    public long cmx() {
        if (this.bUY != null) {
            return this.bUY.amp().amR().cjO.connectTime;
        }
        return 0L;
    }
}
