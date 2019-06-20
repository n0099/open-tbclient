package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String iSa = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String ckK() {
        setUrl(iSa);
        return getResult();
    }

    public long ckL() {
        if (this.mNetWork != null) {
            return this.mNetWork.ahC().aiD().bTJ.Ap;
        }
        return 0L;
    }

    public long ckM() {
        if (this.mNetWork != null) {
            return this.mNetWork.ahC().aiD().bTJ.connectTime;
        }
        return 0L;
    }
}
