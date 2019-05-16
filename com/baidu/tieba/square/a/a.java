package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String iRU = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String ckH() {
        setUrl(iRU);
        return getResult();
    }

    public long ckI() {
        if (this.mNetWork != null) {
            return this.mNetWork.ahC().aiD().bTI.Aq;
        }
        return 0L;
    }

    public long ckJ() {
        if (this.mNetWork != null) {
            return this.mNetWork.ahC().aiD().bTI.connectTime;
        }
        return 0L;
    }
}
