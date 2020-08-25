package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes17.dex */
public class a extends d {
    private static final String lXZ = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String duT() {
        setUrl(lXZ);
        return getResult();
    }

    public long duU() {
        if (this.bDY != null) {
            return this.bDY.biQ().bjx().elw.Lg;
        }
        return 0L;
    }

    public long duV() {
        if (this.bDY != null) {
            return this.bDY.biQ().bjx().elw.connectTime;
        }
        return 0L;
    }
}
