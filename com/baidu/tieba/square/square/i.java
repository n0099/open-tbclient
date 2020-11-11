package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bt;
/* loaded from: classes23.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bt mTq;

    public i(bt btVar) {
        this.mTq = btVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mTq == null) {
            return null;
        }
        return this.mTq.bkw();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bky() {
        if (this.mTq == null) {
            return null;
        }
        return this.mTq.getLink();
    }

    public String dIO() {
        if (this.mTq == null) {
            return null;
        }
        return this.mTq.blR();
    }
}
