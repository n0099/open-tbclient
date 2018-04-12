package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gvD = BdUniqueId.gen();
    private boolean bnv = false;
    private bf gvE;
    private bi gvF;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gvD;
    }

    public boolean brv() {
        return this.bnv;
    }

    public bf brw() {
        return this.gvE;
    }

    public bi brx() {
        return this.gvF;
    }
}
