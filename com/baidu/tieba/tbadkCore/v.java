package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId hcb = BdUniqueId.gen();
    private boolean bMn = false;
    private bd hcc;
    private bg hcd;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hcb;
    }

    public boolean aJe() {
        return this.bMn;
    }

    public bd bBw() {
        return this.hcc;
    }

    public bg bBx() {
        return this.hcd;
    }
}
