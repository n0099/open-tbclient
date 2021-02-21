package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.by;
/* loaded from: classes8.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private by ntt;

    public i(by byVar) {
        this.ntt = byVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.ntt == null) {
            return null;
        }
        return this.ntt.getImgUrl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blL() {
        if (this.ntt == null) {
            return null;
        }
        return this.ntt.getLink();
    }

    public String dMq() {
        if (this.ntt == null) {
            return null;
        }
        return this.ntt.bnh();
    }
}
