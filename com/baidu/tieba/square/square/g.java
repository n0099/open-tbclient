package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd iCC;

    public g(bd bdVar) {
        this.iCC = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.iCC == null) {
            return null;
        }
        return this.iCC.Xk();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xf() {
        if (this.iCC == null) {
            return null;
        }
        return this.iCC.getLink();
    }

    public String cdg() {
        if (this.iCC == null) {
            return null;
        }
        return this.iCC.Yg();
    }
}
