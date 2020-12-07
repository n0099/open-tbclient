package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes23.dex */
public class a extends d {
    private static final String neY = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dNt() {
        setUrl(neY);
        return getResult();
    }

    public long dNu() {
        if (this.cfI != null) {
            return this.cfI.btv().bug().eUJ.MF;
        }
        return 0L;
    }

    public long dNv() {
        if (this.cfI != null) {
            return this.cfI.btv().bug().eUJ.connectTime;
        }
        return 0L;
    }
}
