package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd iVq;

    public g(bd bdVar) {
        this.iVq = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.iVq == null) {
            return null;
        }
        return this.iVq.abS();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        if (this.iVq == null) {
            return null;
        }
        return this.iVq.getLink();
    }

    public String clk() {
        if (this.iVq == null) {
            return null;
        }
        return this.iVq.acN();
    }
}
