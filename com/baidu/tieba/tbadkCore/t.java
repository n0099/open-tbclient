package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class t extends bl {
    public static final BdUniqueId giN = BdUniqueId.gen();
    private bm giO;
    private bp giP;
    private boolean giQ = false;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return giN;
    }

    public boolean bsq() {
        return this.giQ;
    }

    public bm bsr() {
        return this.giO;
    }

    public bp bss() {
        return this.giP;
    }
}
