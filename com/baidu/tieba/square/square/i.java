package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bt;
/* loaded from: classes22.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bt mlc;

    public i(bt btVar) {
        this.mlc = btVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mlc == null) {
            return null;
        }
        return this.mlc.bdu();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bdw() {
        if (this.mlc == null) {
            return null;
        }
        return this.mlc.getLink();
    }

    public String dzt() {
        if (this.mlc == null) {
            return null;
        }
        return this.mlc.beP();
    }
}
