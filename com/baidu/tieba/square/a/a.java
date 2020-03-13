package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String kah = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cJr() {
        setUrl(kah);
        return getResult();
    }

    public long cJs() {
        if (this.cLF != null) {
            return this.cLF.aGg().aGJ().daO.qN;
        }
        return 0L;
    }

    public long cJt() {
        if (this.cLF != null) {
            return this.cLF.aGg().aGJ().daO.connectTime;
        }
        return 0L;
    }
}
