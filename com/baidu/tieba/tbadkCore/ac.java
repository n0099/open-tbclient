package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class ac extends bw {
    public static final BdUniqueId mej = BdUniqueId.gen();
    private boolean fKp = false;
    private by mek;
    private cb mel;

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mej;
    }

    public boolean dwj() {
        return this.fKp;
    }

    public void vZ(boolean z) {
        this.fKp = z;
    }

    public by dwk() {
        return this.mek;
    }

    public void a(by byVar) {
        this.mek = byVar;
    }

    public cb dwl() {
        return this.mel;
    }

    public void a(cb cbVar) {
        this.mel = cbVar;
    }
}
