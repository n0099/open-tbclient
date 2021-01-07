package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes8.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bw nnP;

    public i(bw bwVar) {
        this.nnP = bwVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.nnP == null) {
            return null;
        }
        return this.nnP.getImgUrl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bpn() {
        if (this.nnP == null) {
            return null;
        }
        return this.nnP.getLink();
    }

    public String dNP() {
        if (this.nnP == null) {
            return null;
        }
        return this.nnP.bqI();
    }
}
