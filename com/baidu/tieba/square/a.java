package com.baidu.tieba.square;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private u cKi;

    public a(u uVar) {
        this.cKi = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.cKi == null) {
            return null;
        }
        return this.cKi.sk();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rD() {
        if (this.cKi == null) {
            return null;
        }
        return this.cKi.getLink();
    }
}
