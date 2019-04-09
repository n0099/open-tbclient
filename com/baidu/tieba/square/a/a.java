package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String izh = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String ccD() {
        setUrl(izh);
        return getResult();
    }

    public long ccE() {
        if (this.mNetWork != null) {
            return this.mNetWork.acE().adE().bLX.CG;
        }
        return 0L;
    }

    public long ccF() {
        if (this.mNetWork != null) {
            return this.mNetWork.acE().adE().bLX.connectTime;
        }
        return 0L;
    }
}
