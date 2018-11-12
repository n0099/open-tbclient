package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId hdz = BdUniqueId.gen();
    private boolean bMY = false;
    private bd hdA;
    private bg hdB;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hdz;
    }

    public boolean aIC() {
        return this.bMY;
    }

    public bd bAS() {
        return this.hdA;
    }

    public bg bAT() {
        return this.hdB;
    }
}
