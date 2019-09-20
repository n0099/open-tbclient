package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes5.dex */
public class a extends d {
    private static final String jbQ = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String coH() {
        setUrl(jbQ);
        return getResult();
    }

    public long coI() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiK().ajO().bVt.Av;
        }
        return 0L;
    }

    public long coJ() {
        if (this.mNetWork != null) {
            return this.mNetWork.aiK().ajO().bVt.connectTime;
        }
        return 0L;
    }
}
