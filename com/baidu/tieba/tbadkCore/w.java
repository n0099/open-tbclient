package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class w extends bd {
    public static final BdUniqueId gXn = BdUniqueId.gen();
    private bf gXo;
    private bi gXp;
    private boolean gXq = false;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXn;
    }

    public boolean buY() {
        return this.gXq;
    }

    public bf buZ() {
        return this.gXo;
    }

    public bi bva() {
        return this.gXp;
    }
}
