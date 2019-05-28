package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd iVs;

    public g(bd bdVar) {
        this.iVs = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.iVs == null) {
            return null;
        }
        return this.iVs.abS();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        if (this.iVs == null) {
            return null;
        }
        return this.iVs.getLink();
    }

    public String clm() {
        if (this.iVs == null) {
            return null;
        }
        return this.iVs.acN();
    }
}
