package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes7.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bw njl;

    public i(bw bwVar) {
        this.njl = bwVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.njl == null) {
            return null;
        }
        return this.njl.getImgUrl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blt() {
        if (this.njl == null) {
            return null;
        }
        return this.njl.getLink();
    }

    public String dJX() {
        if (this.njl == null) {
            return null;
        }
        return this.njl.bmO();
    }
}
