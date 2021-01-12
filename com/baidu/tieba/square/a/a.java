package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes7.dex */
public class a extends d {
    private static final String nga = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dJv() {
        setUrl(nga);
        return getResult();
    }

    public long dJw() {
        if (this.chV != null) {
            return this.chV.brX().bsI().eZA.Mc;
        }
        return 0L;
    }

    public long dJx() {
        if (this.chV != null) {
            return this.chV.brX().bsI().eZA.connectTime;
        }
        return 0L;
    }
}
