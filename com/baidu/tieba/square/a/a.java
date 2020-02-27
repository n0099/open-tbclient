package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes10.dex */
public class a extends d {
    private static final String jZT = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cJo() {
        setUrl(jZT);
        return getResult();
    }

    public long cJp() {
        if (this.cLD != null) {
            return this.cLD.aGe().aGH().daM.qN;
        }
        return 0L;
    }

    public long cJq() {
        if (this.cLD != null) {
            return this.cLD.aGe().aGH().daM.connectTime;
        }
        return 0L;
    }
}
