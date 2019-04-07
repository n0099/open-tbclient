package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String izg = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String ccD() {
        setUrl(izg);
        return getResult();
    }

    public long ccE() {
        if (this.mNetWork != null) {
            return this.mNetWork.acE().adE().bLW.CG;
        }
        return 0L;
    }

    public long ccF() {
        if (this.mNetWork != null) {
            return this.mNetWork.acE().adE().bLW.connectTime;
        }
        return 0L;
    }
}
