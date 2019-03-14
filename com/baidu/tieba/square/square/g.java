package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd iCR;

    public g(bd bdVar) {
        this.iCR = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.iCR == null) {
            return null;
        }
        return this.iCR.Xn();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xi() {
        if (this.iCR == null) {
            return null;
        }
        return this.iCR.getLink();
    }

    public String cdk() {
        if (this.iCR == null) {
            return null;
        }
        return this.iCR.Yj();
    }
}
