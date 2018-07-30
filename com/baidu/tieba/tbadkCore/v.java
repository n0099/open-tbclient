package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId gNb = BdUniqueId.gen();
    private boolean bxR = false;
    private bd gNc;
    private bg gNd;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gNb;
    }

    public boolean aDC() {
        return this.bxR;
    }

    public bd bvA() {
        return this.gNc;
    }

    public bg bvB() {
        return this.gNd;
    }
}
