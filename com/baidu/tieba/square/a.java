package com.baidu.tieba.square;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private u cfs;

    public a(u uVar) {
        this.cfs = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.cfs == null) {
            return null;
        }
        return this.cfs.qA();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rt() {
        if (this.cfs == null) {
            return null;
        }
        return this.cfs.getLink();
    }
}
