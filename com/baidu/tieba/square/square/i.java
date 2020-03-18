package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg keV;

    public i(bg bgVar) {
        this.keV = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.keV == null) {
            return null;
        }
        return this.keV.aAJ();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAE() {
        if (this.keV == null) {
            return null;
        }
        return this.keV.getLink();
    }

    public String cKm() {
        if (this.keV == null) {
            return null;
        }
        return this.keV.aBJ();
    }
}
