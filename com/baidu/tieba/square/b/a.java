package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes23.dex */
public class a extends d {
    private static final String mKd = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dFK() {
        setUrl(mKd);
        return getResult();
    }

    public long dFL() {
        if (this.bVi != null) {
            return this.bVi.bon().boV().eIB.LJ;
        }
        return 0L;
    }

    public long dFM() {
        if (this.bVi != null) {
            return this.bVi.bon().boV().eIB.connectTime;
        }
        return 0L;
    }
}
