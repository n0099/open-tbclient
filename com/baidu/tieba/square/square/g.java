package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bd;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private bd jbM;

    public g(bd bdVar) {
        this.jbM = bdVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.jbM == null) {
            return null;
        }
        return this.jbM.acU();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acP() {
        if (this.jbM == null) {
            return null;
        }
        return this.jbM.getLink();
    }

    public String cof() {
        if (this.jbM == null) {
            return null;
        }
        return this.jbM.adP();
    }
}
