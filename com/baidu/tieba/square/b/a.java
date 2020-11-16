package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes22.dex */
public class a extends d {
    private static final String mQT = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dId() {
        setUrl(mQT);
        return getResult();
    }

    public long dIe() {
        if (this.bZh != null) {
            return this.bZh.bqa().bqJ().eNu.LJ;
        }
        return 0L;
    }

    public long dIf() {
        if (this.bZh != null) {
            return this.bZh.bqa().bqJ().eNu.connectTime;
        }
        return 0L;
    }
}
