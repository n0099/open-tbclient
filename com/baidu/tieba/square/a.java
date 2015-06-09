package com.baidu.tieba.square;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private u cjx;

    public a(u uVar) {
        this.cjx = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.cjx == null) {
            return null;
        }
        return this.cjx.rg();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String sd() {
        if (this.cjx == null) {
            return null;
        }
        return this.cjx.getLink();
    }
}
