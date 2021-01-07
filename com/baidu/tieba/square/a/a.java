package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes8.dex */
public class a extends d {
    private static final String nkF = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dNn() {
        setUrl(nkF);
        return getResult();
    }

    public long dNo() {
        if (this.cmJ != null) {
            return this.cmJ.bvR().bwC().fej.Me;
        }
        return 0L;
    }

    public long dNp() {
        if (this.cmJ != null) {
            return this.cmJ.bvR().bwC().fej.connectTime;
        }
        return 0L;
    }
}
