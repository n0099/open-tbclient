package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gwE = BdUniqueId.gen();
    private boolean bnK = false;
    private bf gwF;
    private bi gwG;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gwE;
    }

    public boolean brt() {
        return this.bnK;
    }

    public bf bru() {
        return this.gwF;
    }

    public bi brv() {
        return this.gwG;
    }
}
