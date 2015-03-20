package com.baidu.tieba.square;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private u cfd;

    public a(u uVar) {
        this.cfd = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.cfd == null) {
            return null;
        }
        return this.cfd.qA();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rt() {
        if (this.cfd == null) {
            return null;
        }
        return this.cfd.getLink();
    }
}
