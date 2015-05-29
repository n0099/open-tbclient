package com.baidu.tieba.square;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private u cjw;

    public a(u uVar) {
        this.cjw = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.cjw == null) {
            return null;
        }
        return this.cjw.rg();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String sd() {
        if (this.cjw == null) {
            return null;
        }
        return this.cjw.getLink();
    }
}
