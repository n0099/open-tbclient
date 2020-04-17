package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kOO;

    public i(bg bgVar) {
        this.kOO = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kOO == null) {
            return null;
        }
        return this.kOO.aIW();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIR() {
        if (this.kOO == null) {
            return null;
        }
        return this.kOO.getLink();
    }

    public String cVi() {
        if (this.kOO == null) {
            return null;
        }
        return this.kOO.aJW();
    }
}
