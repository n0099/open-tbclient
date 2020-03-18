package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String kbK = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cJL() {
        setUrl(kbK);
        return getResult();
    }

    public long cJM() {
        if (this.cLQ != null) {
            return this.cLQ.aGk().aGN().dbb.qM;
        }
        return 0L;
    }

    public long cJN() {
        if (this.cLQ != null) {
            return this.cLQ.aGk().aGN().dbb.connectTime;
        }
        return 0L;
    }
}
