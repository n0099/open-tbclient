package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes16.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kyf = BdUniqueId.gen();
    private bw ajx;
    private AntiData ese;
    private boolean kyg = false;
    public boolean kyh = false;

    public o(bw bwVar, AntiData antiData) {
        this.ajx = bwVar;
        this.ese = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kyf;
    }

    public int bgf() {
        if (this.ajx != null) {
            return this.ajx.bgf();
        }
        return 0;
    }

    public boolean cWe() {
        return this.ajx != null && this.ajx.bge() == 1;
    }

    public AntiData getAnti() {
        return this.ese;
    }

    public bw bce() {
        return this.ajx;
    }

    public void sC(boolean z) {
        this.kyg = z;
    }

    public boolean cWf() {
        return this.kyg;
    }
}
