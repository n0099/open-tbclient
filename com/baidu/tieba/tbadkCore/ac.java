package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class ac extends bw {
    public static final BdUniqueId mVY = BdUniqueId.gen();
    private boolean gpM = false;
    private by mVZ;
    private cb mWa;

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mVY;
    }

    public boolean dJy() {
        return this.gpM;
    }

    public void xp(boolean z) {
        this.gpM = z;
    }

    public by dJz() {
        return this.mVZ;
    }

    public void a(by byVar) {
        this.mVZ = byVar;
    }

    public cb dJA() {
        return this.mWa;
    }

    public void a(cb cbVar) {
        this.mWa = cbVar;
    }
}
