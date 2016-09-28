package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class al extends bi {
    public static final BdUniqueId fud = BdUniqueId.gen();
    private bm fue;
    private bp fuf;
    private boolean fug = false;

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fud;
    }

    public boolean bje() {
        return this.fug;
    }

    public void kM(boolean z) {
        this.fug = z;
    }

    public bm bjf() {
        return this.fue;
    }

    public void a(bm bmVar) {
        this.fue = bmVar;
    }

    public bp bjg() {
        return this.fuf;
    }

    public void a(bp bpVar) {
        this.fuf = bpVar;
    }
}
