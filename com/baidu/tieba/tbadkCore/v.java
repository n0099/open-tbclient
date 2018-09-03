package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId gNd = BdUniqueId.gen();
    private boolean bxT = false;
    private bd gNe;
    private bg gNf;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gNd;
    }

    public boolean aDz() {
        return this.bxT;
    }

    public bd bvB() {
        return this.gNe;
    }

    public bg bvC() {
        return this.gNf;
    }
}
