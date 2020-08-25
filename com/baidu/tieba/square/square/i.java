package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bt;
/* loaded from: classes17.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bt mbn;

    public i(bt btVar) {
        this.mbn = btVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mbn == null) {
            return null;
        }
        return this.mbn.bcA();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        if (this.mbn == null) {
            return null;
        }
        return this.mbn.getLink();
    }

    public String dvv() {
        if (this.mbn == null) {
            return null;
        }
        return this.mbn.bdV();
    }
}
