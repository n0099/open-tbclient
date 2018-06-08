package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gId = BdUniqueId.gen();
    private boolean bvQ = false;
    private bf gIe;
    private bi gIf;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gId;
    }

    public boolean bwv() {
        return this.bvQ;
    }

    public bf bww() {
        return this.gIe;
    }

    public bi bwx() {
        return this.gIf;
    }
}
