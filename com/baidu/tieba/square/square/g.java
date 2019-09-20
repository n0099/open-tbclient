package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.be;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private be jfl;

    public g(be beVar) {
        this.jfl = beVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.jfl == null) {
            return null;
        }
        return this.jfl.acZ();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acU() {
        if (this.jfl == null) {
            return null;
        }
        return this.jfl.getLink();
    }

    public String cpk() {
        if (this.jfl == null) {
            return null;
        }
        return this.jfl.adU();
    }
}
