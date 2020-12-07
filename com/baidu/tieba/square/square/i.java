package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bv;
/* loaded from: classes23.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bv nij;

    public i(bv bvVar) {
        this.nij = bvVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.nij == null) {
            return null;
        }
        return this.nij.bmL();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        if (this.nij == null) {
            return null;
        }
        return this.nij.getLink();
    }

    public String dNV() {
        if (this.nij == null) {
            return null;
        }
        return this.nij.bog();
    }
}
