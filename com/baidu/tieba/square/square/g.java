package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd iVw;

    public g(bd bdVar) {
        this.iVw = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.iVw == null) {
            return null;
        }
        return this.iVw.abS();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        if (this.iVw == null) {
            return null;
        }
        return this.iVw.getLink();
    }

    public String cln() {
        if (this.iVw == null) {
            return null;
        }
        return this.iVw.acN();
    }
}
