package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes7.dex */
public class a extends d {
    private static final String jVn = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String cGE() {
        setUrl(jVn);
        return getResult();
    }

    public long cGF() {
        if (this.cHo != null) {
            return this.cHo.aDB().aEd().cWz.qO;
        }
        return 0L;
    }

    public long cGG() {
        if (this.cHo != null) {
            return this.cHo.aDB().aEd().cWz.connectTime;
        }
        return 0L;
    }
}
