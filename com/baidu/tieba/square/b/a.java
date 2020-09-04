package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes17.dex */
public class a extends d {
    private static final String lYo = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String duY() {
        setUrl(lYo);
        return getResult();
    }

    public long duZ() {
        if (this.bEb != null) {
            return this.bEb.biQ().bjx().elA.Lg;
        }
        return 0L;
    }

    public long dva() {
        if (this.bEb != null) {
            return this.bEb.biQ().bjx().elA.connectTime;
        }
        return 0L;
    }
}
