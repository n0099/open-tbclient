package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.be;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private be jcQ;

    public g(be beVar) {
        this.jcQ = beVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.jcQ == null) {
            return null;
        }
        return this.jcQ.acV();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acQ() {
        if (this.jcQ == null) {
            return null;
        }
        return this.jcQ.getLink();
    }

    public String cox() {
        if (this.jcQ == null) {
            return null;
        }
        return this.jcQ.adQ();
    }
}
