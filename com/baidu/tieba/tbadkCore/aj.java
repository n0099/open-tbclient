package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class aj extends bg {
    public static final BdUniqueId ffv = BdUniqueId.gen();
    private bj ffw;
    private bm ffx;
    private boolean ffy = false;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ffv;
    }

    public boolean bfo() {
        return this.ffy;
    }

    public void kU(boolean z) {
        this.ffy = z;
    }

    public bj bfp() {
        return this.ffw;
    }

    public void a(bj bjVar) {
        this.ffw = bjVar;
    }

    public bm bfq() {
        return this.ffx;
    }

    public void a(bm bmVar) {
        this.ffx = bmVar;
    }
}
