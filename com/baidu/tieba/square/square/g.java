package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.be;
/* loaded from: classes5.dex */
public class g implements com.baidu.tbadk.core.flow.a.a {
    private be jel;

    public g(be beVar) {
        this.jel = beVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.jel == null) {
            return null;
        }
        return this.jel.ahd();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String agY() {
        if (this.jel == null) {
            return null;
        }
        return this.jel.getLink();
    }

    public String cmZ() {
        if (this.jel == null) {
            return null;
        }
        return this.jel.ahW();
    }
}
