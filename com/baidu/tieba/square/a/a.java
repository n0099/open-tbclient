package com.baidu.tieba.square.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.d;
/* loaded from: classes8.dex */
public class a extends d {
    private static final String nkG = TbConfig.SERVER_ADDRESS + TbConfig.FORUM_SQUARE;

    public String dNm() {
        setUrl(nkG);
        return getResult();
    }

    public long dNn() {
        if (this.cmJ != null) {
            return this.cmJ.bvQ().bwB().fej.Me;
        }
        return 0L;
    }

    public long dNo() {
        if (this.cmJ != null) {
            return this.cmJ.bvQ().bwB().fej.connectTime;
        }
        return 0L;
    }
}
