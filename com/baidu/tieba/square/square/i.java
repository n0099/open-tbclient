package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bs;
/* loaded from: classes17.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bs lJE;

    public i(bs bsVar) {
        this.lJE = bsVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.lJE == null) {
            return null;
        }
        return this.lJE.aUh();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aUj() {
        if (this.lJE == null) {
            return null;
        }
        return this.lJE.getLink();
    }

    public String djY() {
        if (this.lJE == null) {
            return null;
        }
        return this.lJE.aVC();
    }
}
