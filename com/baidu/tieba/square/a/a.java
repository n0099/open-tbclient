package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String jZV = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cJq() {
        setUrl(jZV);
        return getResult();
    }

    public long cJr() {
        if (this.cLE != null) {
            return this.cLE.aGg().aGJ().daN.qN;
        }
        return 0L;
    }

    public long cJs() {
        if (this.cLE != null) {
            return this.cLE.aGg().aGJ().daN.connectTime;
        }
        return 0L;
    }
}
