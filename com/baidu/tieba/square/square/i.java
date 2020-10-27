package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bt;
/* loaded from: classes23.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bt mNn;

    public i(bt btVar) {
        this.mNn = btVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mNn == null) {
            return null;
        }
        return this.mNn.bhW();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bhY() {
        if (this.mNn == null) {
            return null;
        }
        return this.mNn.getLink();
    }

    public String dGm() {
        if (this.mNn == null) {
            return null;
        }
        return this.mNn.bjr();
    }
}
