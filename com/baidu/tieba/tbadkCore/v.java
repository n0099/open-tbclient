package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gZY = BdUniqueId.gen();
    private boolean cdF = false;
    private bf gZZ;
    private bi haa;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gZY;
    }

    public boolean bwr() {
        return this.cdF;
    }

    public bf bws() {
        return this.gZZ;
    }

    public bi bwt() {
        return this.haa;
    }
}
