package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kdg;

    public i(bg bgVar) {
        this.kdg = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kdg == null) {
            return null;
        }
        return this.kdg.aAG();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAB() {
        if (this.kdg == null) {
            return null;
        }
        return this.kdg.getLink();
    }

    public String cJR() {
        if (this.kdg == null) {
            return null;
        }
        return this.kdg.aBG();
    }
}
