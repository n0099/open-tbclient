package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId hkt = BdUniqueId.gen();
    private boolean bQP = false;
    private bd hku;
    private bg hkv;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hkt;
    }

    public boolean aKt() {
        return this.bQP;
    }

    public bd bCN() {
        return this.hku;
    }

    public bg bCO() {
        return this.hkv;
    }
}
