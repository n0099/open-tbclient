package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bh;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bh lhi;

    public i(bh bhVar) {
        this.lhi = bhVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.lhi == null) {
            return null;
        }
        return this.lhi.aOP();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aOK() {
        if (this.lhi == null) {
            return null;
        }
        return this.lhi.getLink();
    }

    public String dck() {
        if (this.lhi == null) {
            return null;
        }
        return this.lhi.aPP();
    }
}
