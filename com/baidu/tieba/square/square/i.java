package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bs;
/* loaded from: classes17.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bs lJC;

    public i(bs bsVar) {
        this.lJC = bsVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.lJC == null) {
            return null;
        }
        return this.lJC.aUh();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aUj() {
        if (this.lJC == null) {
            return null;
        }
        return this.lJC.getLink();
    }

    public String djY() {
        if (this.lJC == null) {
            return null;
        }
        return this.lJC.aVC();
    }
}
