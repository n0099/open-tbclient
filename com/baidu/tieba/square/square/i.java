package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bt;
/* loaded from: classes23.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bt mAD;

    public i(bt btVar) {
        this.mAD = btVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mAD == null) {
            return null;
        }
        return this.mAD.bgd();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bgf() {
        if (this.mAD == null) {
            return null;
        }
        return this.mAD.getLink();
    }

    public String dDe() {
        if (this.mAD == null) {
            return null;
        }
        return this.mAD.bhy();
    }
}
