package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kds;

    public i(bg bgVar) {
        this.kds = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kds == null) {
            return null;
        }
        return this.kds.aAG();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAB() {
        if (this.kds == null) {
            return null;
        }
        return this.kds.getLink();
    }

    public String cJS() {
        if (this.kds == null) {
            return null;
        }
        return this.kds.aBG();
    }
}
