package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lit = BdUniqueId.gen();
    private bw akq;
    private AntiData eOT;
    private boolean liu = false;
    public boolean liv = false;

    public o(bw bwVar, AntiData antiData) {
        this.akq = bwVar;
        this.eOT = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lit;
    }

    public int blB() {
        if (this.akq != null) {
            return this.akq.blB();
        }
        return 0;
    }

    public boolean dgA() {
        return this.akq != null && this.akq.blA() == 1;
    }

    public AntiData getAnti() {
        return this.eOT;
    }

    public bw bhz() {
        return this.akq;
    }

    public void tJ(boolean z) {
        this.liu = z;
    }

    public boolean dgB() {
        return this.liu;
    }
}
