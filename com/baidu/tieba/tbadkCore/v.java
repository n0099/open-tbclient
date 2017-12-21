package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gBa = BdUniqueId.gen();
    private bf gBb;
    private bi gBc;
    private boolean gBd = false;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gBa;
    }

    public boolean bwn() {
        return this.gBd;
    }

    public bf bwo() {
        return this.gBb;
    }

    public bi bwp() {
        return this.gBc;
    }
}
