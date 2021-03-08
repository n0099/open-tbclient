package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes7.dex */
public class a extends d {
    private static final String nsn = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dLW() {
        setUrl(nsn);
        return getResult();
    }

    public long dLX() {
        if (this.cnM != null) {
            return this.cnM.bsu().btf().fdp.Nv;
        }
        return 0L;
    }

    public long dLY() {
        if (this.cnM != null) {
            return this.cnM.bsu().btf().fdp.connectTime;
        }
        return 0L;
    }
}
