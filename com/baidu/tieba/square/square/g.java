package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.be;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private be jfc;

    public g(be beVar) {
        this.jfc = beVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.jfc == null) {
            return null;
        }
        return this.jfc.ahf();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aha() {
        if (this.jfc == null) {
            return null;
        }
        return this.jfc.getLink();
    }

    public String cnb() {
        if (this.jfc == null) {
            return null;
        }
        return this.jfc.ahY();
    }
}
