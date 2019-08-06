package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String iZv = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cnU() {
        setUrl(iZv);
        return getResult();
    }

    public long cnV() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiG().ajI().bUQ.Av;
        }
        return 0L;
    }

    public long cnW() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiG().ajI().bUQ.connectTime;
        }
        return 0L;
    }
}
