package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes21.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kGJ = BdUniqueId.gen();
    private bw ajX;
    private AntiData eun;
    private boolean kGK = false;
    public boolean kGL = false;

    public o(bw bwVar, AntiData antiData) {
        this.ajX = bwVar;
        this.eun = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kGJ;
    }

    public int bgZ() {
        if (this.ajX != null) {
            return this.ajX.bgZ();
        }
        return 0;
    }

    public boolean cZJ() {
        return this.ajX != null && this.ajX.bgY() == 1;
    }

    public AntiData getAnti() {
        return this.eun;
    }

    public bw bcY() {
        return this.ajX;
    }

    public void sL(boolean z) {
        this.kGK = z;
    }

    public boolean cZK() {
        return this.kGK;
    }
}
