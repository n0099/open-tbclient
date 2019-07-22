package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String iYr = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cnC() {
        setUrl(iYr);
        return getResult();
    }

    public long cnD() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiE().ajG().bUK.Av;
        }
        return 0L;
    }

    public long cnE() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiE().ajG().bUK.connectTime;
        }
        return 0L;
    }
}
