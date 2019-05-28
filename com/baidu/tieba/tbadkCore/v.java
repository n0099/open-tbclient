package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iXJ = BdUniqueId.gen();
    private boolean drA = false;
    private bi iXK;
    private bl iXL;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iXJ;
    }

    public boolean bte() {
        return this.drA;
    }

    public void qI(boolean z) {
        this.drA = z;
    }

    public bi clR() {
        return this.iXK;
    }

    public void a(bi biVar) {
        this.iXK = biVar;
    }

    public bl clS() {
        return this.iXL;
    }

    public void a(bl blVar) {
        this.iXL = blVar;
    }
}
