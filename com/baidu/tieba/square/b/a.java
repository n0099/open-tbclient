package com.baidu.tieba.square.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes17.dex */
public class a extends d {
    private static final String lGr = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String djw() {
        setUrl(lGr);
        return getResult();
    }

    public long djx() {
        if (this.byq != null) {
            return this.byq.bav().baY().ebN.KD;
        }
        return 0L;
    }

    public long djy() {
        if (this.byq != null) {
            return this.byq.bav().baY().ebN.connectTime;
        }
        return 0L;
    }
}
