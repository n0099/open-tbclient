package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.by;
/* loaded from: classes7.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private by nvy;

    public i(by byVar) {
        this.nvy = byVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.nvy == null) {
            return null;
        }
        return this.nvy.getImgUrl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blN() {
        if (this.nvy == null) {
            return null;
        }
        return this.nvy.getLink();
    }

    public String dMy() {
        if (this.nvy == null) {
            return null;
        }
        return this.nvy.bnj();
    }
}
