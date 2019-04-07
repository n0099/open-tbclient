package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd iCB;

    public g(bd bdVar) {
        this.iCB = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.iCB == null) {
            return null;
        }
        return this.iCB.Xk();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xf() {
        if (this.iCB == null) {
            return null;
        }
        return this.iCB.getLink();
    }

    public String cdg() {
        if (this.iCB == null) {
            return null;
        }
        return this.iCB.Yg();
    }
}
