package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String jbH = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cmx() {
        setUrl(jbH);
        return getResult();
    }

    public long cmy() {
        if (this.bVP != null) {
            return this.bVP.amr().amT().ckF.oU;
        }
        return 0L;
    }

    public long cmz() {
        if (this.bVP != null) {
            return this.bVP.amr().amT().ckF.connectTime;
        }
        return 0L;
    }
}
