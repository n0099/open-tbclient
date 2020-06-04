package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bh;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bh lir;

    public i(bh bhVar) {
        this.lir = bhVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.lir == null) {
            return null;
        }
        return this.lir.aOP();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aOK() {
        if (this.lir == null) {
            return null;
        }
        return this.lir.getLink();
    }

    public String dcz() {
        if (this.lir == null) {
            return null;
        }
        return this.lir.aPP();
    }
}
