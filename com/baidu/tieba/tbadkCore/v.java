package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iXN = BdUniqueId.gen();
    private boolean drA = false;
    private bi iXO;
    private bl iXP;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iXN;
    }

    public boolean btf() {
        return this.drA;
    }

    public void qJ(boolean z) {
        this.drA = z;
    }

    public bi clS() {
        return this.iXO;
    }

    public void a(bi biVar) {
        this.iXO = biVar;
    }

    public bl clT() {
        return this.iXP;
    }

    public void a(bl blVar) {
        this.iXP = blVar;
    }
}
