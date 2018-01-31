package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class w extends bd {
    public static final BdUniqueId gXH = BdUniqueId.gen();
    private bf gXI;
    private bi gXJ;
    private boolean gXK = false;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXH;
    }

    public boolean bva() {
        return this.gXK;
    }

    public bf bvb() {
        return this.gXI;
    }

    public bi bvc() {
        return this.gXJ;
    }
}
