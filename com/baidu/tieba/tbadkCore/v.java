package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gZJ = BdUniqueId.gen();
    private boolean cdt = false;
    private bf gZK;
    private bi gZL;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gZJ;
    }

    public boolean bwq() {
        return this.cdt;
    }

    public bf bwr() {
        return this.gZK;
    }

    public bi bws() {
        return this.gZL;
    }
}
