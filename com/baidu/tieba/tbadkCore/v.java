package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iXH = BdUniqueId.gen();
    private boolean drz = false;
    private bi iXI;
    private bl iXJ;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iXH;
    }

    public boolean btb() {
        return this.drz;
    }

    public void qI(boolean z) {
        this.drz = z;
    }

    public bi clP() {
        return this.iXI;
    }

    public void a(bi biVar) {
        this.iXI = biVar;
    }

    public bl clQ() {
        return this.iXJ;
    }

    public void a(bl blVar) {
        this.iXJ = blVar;
    }
}
